import java.net.*;
import java.io.*;
import java.util.*;
public class ChatServer
{
ServerSocket serverSocket;
public ChatServer()
{
try{
serverSocket = new ServerSocket(5005);
while(true)
{
Socket s = serverSocket.accept();
new ChatHandler(s);
}
}
catch (IOException e) {
      e.printStackTrace();
}
}
public static void main(String[] args)
{
new ChatServer();
}
}