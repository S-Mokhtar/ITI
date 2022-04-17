import java.net.ServerSocket;
import java.net.Socket;
import java.io.IOException;
import java.io.PrintStream;
import java.lang.Thread;
import java.util.Vector;
import java.io.BufferedReader;
import java.io.InputStreamReader;
 
public class Server {
    ServerSocket serverSocket;
    public Server() {
        try {
            serverSocket = new ServerSocket(5005);
            System.out.println("Server is running on port 5005");
        } catch (IOException e) {
            e.printStackTrace();
        }
        while (true) {
            try {
                Socket socket = serverSocket.accept();
                System.out.println("New client connected");
                ClientHandler ch = new ClientHandler(socket);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
 
    public static void main(String[] args) {
        Server server = new Server();
    }
}
 
enum status{
    OFFLINE,
    ONLINE,
    INGAME
}

class ClientHandler extends Thread {
    Socket socket;
    BufferedReader dis;
    PrintStream ps;
    boolean running = true;
    static Vector<ClientHandler> clients = new Vector<ClientHandler>();
    int myID, p2ID;
    status myStatus=status.INGAME;
    public ClientHandler(Socket socket) {
        this.socket = socket;
        try {
            dis = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        try {
            ps = new PrintStream(socket.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
 
        myID = clients.size();
        if(myID == 0)
            p2ID = 1;
        else if (myID == 1)
            p2ID=0;
        ps.println(myID);
        clients.add(this);
        start();
    }
 
    public void run() {
        String str;
        while (running) {
            try {
                String signal = dis.readLine();
               if (signal.equals("MOVE")) {
                    str = dis.readLine();
                     String value=dis.readLine();
                    System.out.println("MOVE: " + str);
                    System.out.println("MOVE: " + value);
                    if (str != null) {
                        sendMessage(p2ID, str,value);
                        sendMessage(myID, str,value);
                    }
 
                }else if (signal.equals("START")) {
                    System.out.println("start "+ myID);
                    for(ClientHandler ch : clients){
                        if(ch != this){
                            ch.ps.println("START");
                        }
                    }
 
                }else if (signal.equals("OK")) {
                    System.out.println("OK "+ myID);
                    ps.println("INIT");
                    ps.println("false");
                    
                    for(ClientHandler ch : clients){
                        if(ch != this){
                           ch. ps.println("INIT");
                            ch. ps.println("true");
                        }
                    }
                }
                else {
                    handleGameDisconnected();
                    handleClientDisconnected();
                }
 
            } catch (IOException e) {
                handleGameDisconnected();
                handleClientDisconnected();
            }
        }
        closeConnection();
    }
    
    void broadcastMessage(String s) {
        for (ClientHandler c : clients) {
            c.ps.println("RUN");
            c.ps.println(s);
        }
    }
 
    void sendMessage(int id, String s,String val) {
        clients.get(id).ps.println("MOVE");
        clients.get(id).ps.println(s);
        clients.get(id).ps.println(val);
 
    }
 
    void handleGameDisconnected(){
       if(myStatus==status.INGAME){
        for(ClientHandler ch : clients){
            if(ch != this){
              ch.ps.println("DISCONNECT");
            }
        }
       }
     
    }
    void handleClientDisconnected() {
        running = false;
        ps.println("CLOSE");
        clients.remove(this);
        System.out.println("Client disconnected: " + clients.size());
    }
 
    void closeConnection() {
        try {
            ps.close();
            dis.close();
            socket.close();
            System.out.println("Connection Terminated!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
