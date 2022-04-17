/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serversidechat;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.net.SocketException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Abdo
 */
public class ChatHandler extends Thread {

    DataInputStream dataInputStream;
    PrintStream printStream;
    static Vector<ChatHandler> chatHandlersList = new Vector<>();

    public ChatHandler(Socket socket) {
        try {
            dataInputStream = new DataInputStream(socket.getInputStream());
            printStream = new PrintStream(socket.getOutputStream());
            ChatHandler.chatHandlersList.add(this);
            start();
        } catch (IOException ex) {
            //sLogger.getLogger(ChatHandler.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void run() {
        while (true) {
            try {
                String message = dataInputStream.readLine();
                for (ChatHandler handler : chatHandlersList) {
                    handler.printStream.println(message);
                }
            } catch (IOException ex) {
                try {
                   if (dataInputStream != null)  dataInputStream.close();
                   if (printStream != null)  printStream.close();
                    chatHandlersList.remove(this);
                    break;
                    //Logger.getLogger(ChatHandler.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex1) {
                    //Logger.getLogger(ChatHandler.class.getName()).log(Level.SEVERE, null, ex1);
                }
            }
        }
    }

}
