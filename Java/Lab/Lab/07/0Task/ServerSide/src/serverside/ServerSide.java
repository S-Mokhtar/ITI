/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serverside;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author METRO
 */
public class ServerSide {

    /**
     * @param args the command line arguments
     */
    ServerSocket myServerSocket;
    Socket s;
    DataInputStream dis;
    PrintStream ps;

    public static void main(String[] args) {
        try {
            new ServerSide();
        } catch (IOException ex) {
            Logger.getLogger(ServerSide.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ServerSide() throws IOException {
        try {
            myServerSocket = new ServerSocket(5005);
            s = myServerSocket.accept();
            dis = new DataInputStream(s.getInputStream());
            ps = new PrintStream(s.getOutputStream());
            String msg = dis.readLine();
            System.out.println(msg);
            ps.println("Data Received");
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            try {
                ps.close();
                dis.close();
                s.close();
                myServerSocket.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
}
