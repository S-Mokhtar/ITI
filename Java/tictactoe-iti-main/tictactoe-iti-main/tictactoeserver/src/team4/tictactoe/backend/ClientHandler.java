/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package team4.tictactoe.backend;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import team4.tictactoe.backend.config.RequestFormatter;
import team4.tictactoe.backend.controllers.auth.AuthController;
import team4.tictactoe.backend.models.Login;
import team4.tictactoe.backend.models.NewUser;
import team4.tictactoe.backend.models.User;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
enum status {
    ONLINE, OFFLINE, INGAME, WAITING
}
public class ClientHandler extends Thread {
    static Vector<ClientHandler> clients = new Vector<ClientHandler>();
    static HashMap<Integer, ClientHandler> clientsMap = new HashMap<>();
    static Vector<GameRoom> rooms = new Vector<GameRoom>();
    Socket socket;
    BufferedReader bufferedReader;
    PrintStream printStream;
    boolean running = true;
    status myStatus = status.ONLINE;
    GameRoom g;
    ObservableList<User> userList = FXCollections.observableArrayList();
    ObjectMapper mapper = new ObjectMapper();
    // mapper.enable(SerializationFeature.INDENT_OUTPUT);
    DataBase d = new DataBase();
    int myID = 0;
    public ClientHandler(Socket socket) {
        ///
        // mapper.enable(SerializationFeature.INDENT_OUTPUT);
        this.socket = socket;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            printStream = new PrintStream(socket.getOutputStream());
        } catch (IOException e) {
            System.out.println(1);
            e.printStackTrace();
        }
        myID = clients.size() + 1;
        clientsMap.put(myID, this);
        clients.add(this);
        start();
    }
    public void run() {
        String str;
        while (running) {
            try {
                String signal = bufferedReader.readLine();
                System.out.println(signal);
                switch (signal) {
                    case "RUN":
                        try {
                            sendUsers();
                        } catch (SQLException | JsonProcessingException ex) {
                            Logger.getLogger(ClientHandler.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        break;
                    case "MOVE":
                        str = bufferedReader.readLine();
                        String value = bufferedReader.readLine();
                        System.out.println("MOVE: " + str);
                        System.out.println("MOVE: " + value);
                        if (str != null) {
                            sendMessage(str, value);
                        }
                        break;
                    case "REQUEST":
                        str = bufferedReader.readLine();
                        int temp = d.playerId(str);
                        g = new GameRoom(1, clientsMap.get(myID), clientsMap.get(temp));
                        //System.out.println("id:"+ myID+ "temp:"+temp );
                        clientsMap.get(temp).g = g;
                        g.player2.myStatus = status.WAITING;
                        g.player1.myStatus = status.WAITING;
                        clientsMap.get(temp).printStream.println("GAME");
                        clientsMap.get(temp).printStream.println(str);
                        //rooms.add(new GameRoom(1, clientsMap.get(myID), clientsMap.get(temp)));
                        //g=new GameRoom(1, clientsMap.get(myID), clientsMap.get(temp));
                        rooms.add(g);
                        break;
                    case "ok":
                        if (g == null) {
                            System.out.println(myID);
                        }
                        g.player1.printStream.println("start");
                        g.player1.printStream.println("true");
                        g.player2.printStream.println("start");
                        g.player2.printStream.println("false");
                        g.player2.myStatus = status.INGAME;
                        g.player1.myStatus = status.INGAME;
                        // myStatus=status.inGame;
                        break;
                    case "cancel":
                        g.player1.printStream.println("cancel");
                        g.player2.myStatus = status.ONLINE;
                        g.player1.myStatus = status.ONLINE;
                        rooms.remove(g);
                        break;
                    case "end":
                        g.player2.myStatus = status.ONLINE;
                        g.player1.myStatus = status.ONLINE;
                        rooms.remove(g);
                        break;
                    default:
//                        String message = bufferedReader.readLine();
                        ObjectMapper objectMapper = new ObjectMapper();
//                        JsonNode jsonNode = objectMapper.readTree(message);
                        JsonNode jsonNode = objectMapper.readTree(signal);
                        String type = jsonNode.get("type").toString().replaceAll("\"", "");
                        JsonNode data = jsonNode.get("data");
                        System.out.println("Type is " + type);
                        System.out.println("Data is " + data);
                        String response;
                        switch (type) {
                            case "login":
                                Login login = objectMapper.readValue(data.toString(), Login.class);
                                response = AuthController.login(login);
                                System.out.println("Response is " + response);
                                printStream.println(response);
                                response = RequestFormatter.formatMessage("", "player_status", true);
                                printStream.println(response);
                                break;
                            case "register":
                                NewUser newUser = objectMapper.readValue(data.toString(), NewUser.class);
                                response = AuthController.register(newUser);
                                System.out.println("Response is " + response);
                                printStream.println(response);
                                response = RequestFormatter.formatMessage("", "player_status", true);
                                printStream.println(response);
                                break;
                            default:
//                                handlebufferedReaderconnectInRequest();
//                                handleClientbufferedReaderconnected();
                                break;
                        }
                }
            } catch (Exception e) {
                System.out.println(2);
                e.printStackTrace();
                handleClientbufferedReaderconnected();
                handlebufferedReaderconnectInRequest();
            }
        }
        closeConnection();
    }
    void broadcastMessage(String s) {
        for (ClientHandler c : clients) {
            c.printStream.println("RUN");
            c.printStream.println(s);
        }
    }
    void handleClientbufferedReaderconnected() {
        running = false;
        printStream.println("CLOSE");
        clients.remove(this);
        clientsMap.remove(myID);
        System.out.println("Client bufferedReaderconnected: " + clients.size());
    }
    void closeConnection() {
        try {
            printStream.close();
            bufferedReader.close();
            socket.close();
            System.out.println("Connection Terminated!");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println(3);
        }
    }
    void sendUsers() throws SQLException, JsonProcessingException {
        userList = d.selectusers();
        String listJson = mapper.writeValueAsString(userList);
        for (ClientHandler c : clients) {
            c.printStream.println("RUN");
            c.printStream.println(listJson);
        }
    }
    void handlebufferedReaderconnectInRequest() {
        if (this.myStatus == status.WAITING) {
            if (g.player1 == this) {
                g.player2.printStream.println("forceClose");
            } else if (g.player2 == this) {
                g.player1.printStream.println("cancel");
            }
        } else if (this.myStatus == status.INGAME) {
            if (g.player1 == this) {
                g.player2.printStream.println("bufferedReaderCONNECT");
            } else if (g.player2 == this) {
                g.player1.printStream.println("bufferedReaderCONNECT");
            }
        }
        rooms.remove(g);
    }
    void sendMessage(String s, String val) {
        g.player1.printStream.println("MOVE");
        g.player2.printStream.println("MOVE");
        g.player1.printStream.println(s);
        g.player2.printStream.println(s);
        g.player1.printStream.println(val);
        g.player2.printStream.println(val);
    }
}
