package team4.tictactoe.backend;
import team4.tictactoe.backend.config.DBConnection;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Connection;
import java.sql.SQLException;
public class Server {
    public static boolean running = true;
    private static Connection connection;
    ServerSocket serverSocket;
    public Server() {
        try {
            serverSocket = new ServerSocket(5005);
            System.out.println("Server is running on port 5005");
            while (true) {
                try {
                    Socket socket = serverSocket.accept();
                    System.out.println("New client connected");
                    /// OPEN NEW THREAD FOR THE NEW CLIENT
                    new ClientHandler(socket);
                } catch (IOException e) {
                    System.out.println(4);
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            System.out.println(5);
            e.printStackTrace();
        }
    }
    public static Connection getConnection() {
        return connection;
    }
    public static void main(String[] args) throws SQLException {
        Server.connection = new DBConnection().getConnection();
        new Server();
    }
}
 
