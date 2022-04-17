package javafxapplication5;

import javax.swing.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.awt.*;
import java.net.Socket;
import java.net.UnknownHostException;
import java.net.InetAddress;
import javafx.application.Platform;
import javafx.scene.control.Alert;
import javafxapplication5.FXMLDocumentController;
 
 class Client  implements Runnable {
    FXMLDocumentController controller;
    Socket socket;
    BufferedReader dis;
    PrintStream printStream;
    Thread th;
    boolean running = true;
    boolean symbol = true;
    int myID;
    int p2ID;
 
    public Client(FXMLDocumentController controller) {
        this.controller = controller;
        try {
            socket = new Socket(InetAddress.getLocalHost(), 5005);
            dis = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            printStream = new PrintStream(socket.getOutputStream());
 
            myID = Integer.parseInt(dis.readLine());
            if(myID == 1){
                p2ID =0;
            }else if (myID == 0){
                p2ID =1;
            }
            System.out.println("My id : " + myID);
        } catch (UnknownHostException e) {
            System.out.println("Server Inaccessible #1");
        } catch (IOException e) {
            System.out.println("Server Inaccessible #2");
        }
        th = new Thread(this);
        th.start();
    }

    void sendMove(String loc,String val) {
           printStream.println("MOVE");
           System.out.println("sending move1 "+ loc);
           printStream.println(loc);
            System.out.println("sending move2 "+ loc);
            printStream.println(val);
            System.out.println("sending move2 "+ val);
    }
  
    public void run() {
        while (running) {
            try {
                String signal = "";
                if (dis != null)
                    signal = dis.readLine();

                if (signal.equals("MOVE")) {
                    String location = dis.readLine();
                    String value=dis.readLine();
                    System.out.println("Move "+ location);
                    Platform.runLater(new Runnable(){
                        @Override
                        public void run(){
                           controller.sendPlay(Integer.parseInt(location),value);
                        }
                    });
                     
                }else if (signal.equals("START")) {
                    System.out.println("start "+ myID);
                   printStream.println("OK");
                    
                    
                }else if (signal.equals("INIT")) {
                    System.out.println("init "+ myID);
                    symbol = Boolean.parseBoolean(dis.readLine());
                    controller.initGame(symbol);
       
                }
                else if (signal.equals("DISCONNECT")) {
                     Platform.runLater(new Runnable(){
                        @Override
                        public void run(){
                    Alert a = new Alert(Alert.AlertType.NONE);
                    a.setAlertType(Alert.AlertType.CONFIRMATION);
                    a.setContentText("The other player disconnected! You are the winner");
                    a.show();
                        }
                    });
                }
                else {
                    handleServerDisconnect();
                }
 
            } catch (IOException e) {
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
}