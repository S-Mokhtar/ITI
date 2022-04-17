package team4.tictactoe.models;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import team4.tictactoe.TicTacToeApplication;
import team4.tictactoe.controllers.GameController;
import team4.tictactoe.controllers.players.PlayersController;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
public class Client implements Runnable {
    public static Client client;
    GameController controller;
    Socket socket;
    BufferedReader dis;
    PrintStream printStream;
    Thread th;
    boolean running = true;
    boolean symbol = true;
    ObservableList<User> userList = FXCollections.observableArrayList();
    List<User> users = new ArrayList<>();
    PlayersController t;
    ObjectMapper mapper = new ObjectMapper();
    String message;
    public Client() throws IOException {
        t = TicTacToeApplication.t;
        controller = TicTacToeApplication.controller;
        try {
            socket = new Socket(InetAddress.getLocalHost(), 5005);
            dis = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            printStream = new PrintStream(socket.getOutputStream());
            printStream.println("RUN");
        } catch (UnknownHostException e) {
            System.out.println("Server Inaccessible #1");
        } catch (IOException e) {
            System.out.println("Server Inaccessible #2");
        }
        th = new Thread(this);
        th.start();
    }
    public void run() {
        while (running) {
            try {
                String signal = "";
                signal = dis.readLine();
                switch (signal) {
                    case "RUN":
                        message = dis.readLine();
                        users = mapper.readValue(message, new TypeReference<List<User>>() {
                        });
                        userList = FXCollections.observableArrayList(users);
                        t.loadUsers(userList);
                        break;
                    case "GAME":
                        message = dis.readLine();
                        Platform.runLater(() -> {
                            message = t.acceptGame(message);
                            printStream.println(message);
                        });
                        break;
                    case "start":
                        System.out.println("start");
                        symbol = Boolean.parseBoolean(dis.readLine());
                        Platform.runLater(() -> {
                            TicTacToeApplication.gameScene = new Scene(TicTacToeApplication.window2);
                            TicTacToeApplication.stage.setScene(TicTacToeApplication.gameScene);
                            TicTacToeApplication.stage.show();
                            System.out.println(symbol);
                            controller.initGame(symbol);
                        });
                        break;
                    case "DISCONNECT":
                        Platform.runLater(() -> {
                            Alert a = new Alert(Alert.AlertType.NONE);
                            a.setAlertType(Alert.AlertType.CONFIRMATION);
                            a.setContentText("The other player disconnected! You are the winner");
                            a.show();
                        });
                        break;
                    case "forceClose":
                        System.out.println("forceClose");
                        Platform.runLater(() -> t.cancelAlert());
                        break;
                    case "cancel":
                        Platform.runLater(() -> {
                            TicTacToeApplication.stage.setScene(TicTacToeApplication.mainScene);
                            TicTacToeApplication.stage.show();
                            t.loadUsers(userList);
                        });
                        break;
                    case "MOVE":
                        String location = dis.readLine();
                        String value = dis.readLine();
                        System.out.println("Move " + location);
                        Platform.runLater(() -> controller.sendPlay(Integer.parseInt(location), value));
                        break;
                    default:
                        /// HANDLE CLOSE
                        System.out.println(signal);
                        handleServerDisconnect();
                        break;
                }
            } catch (IOException e) {
                /// HANDLE CLOSE UNEXPECTED
                handleServerDisconnect();
            }
        }
        closeConnection();
        System.exit(0);
    }
    void handleServerDisconnect() {
        if (printStream != null) {
            running = false;
            printStream.println("CLOSE");
        } else {
            System.exit(0);
        }
    }
    public void sendMove(String loc, String val) {
        printStream.println("MOVE");
        System.out.println("sending move1 " + loc);
        printStream.println(loc);
        System.out.println("sending move2 " + loc);
        printStream.println(val);
        System.out.println("sending move2 " + val);
    }
    void closeConnection() {
        try {
            printStream.close();
            dis.close();
            socket.close();
            System.out.println("Connection Terminated!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void requestGame(String s) {
        printStream.println("REQUEST");
        printStream.println(s);
    }
    public void endGame() {
        printStream.println("end");
    }
}
