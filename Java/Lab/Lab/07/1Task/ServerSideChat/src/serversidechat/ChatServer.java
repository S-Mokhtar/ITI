/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serversidechat;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Abdo
 */
public class ChatServer {

    ServerSocket serverSocket;

    public ChatServer() {
       
        try {
            serverSocket = new ServerSocket(5005);
            while (true) {
                Socket socket = serverSocket.accept();
                new ChatHandler(socket);
            }       
        } catch (IOException ex) {
            Logger.getLogger(ChatServer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    

    public static void main(String[] args) {
        new ChatServer();
    }
    
}
