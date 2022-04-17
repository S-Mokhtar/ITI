import java.net.*;
import java.io.*;
public class Server
{
ServerSocket myServerSocket;
Socket s;
DataInputStream dis ;
PrintStream ps;
public static void main(String[] args)
{
new Server();
}
public Server()
{
try
{
myServerSocket = new ServerSocket(5005);
s = myServerSocket.accept ();
dis = new DataInputStream(s.getInputStream ());
ps = new PrintStream(s.getOutputStream ());
String msg = dis.readLine();
System.out.println(msg);
ps.println("Data Received");
}
catch(IOException ex)
{
ex.printStackTrace();
}
try
{
ps.close();
dis.close();
s.close();
myServerSocket.close();
}
catch(Exception ex)
{
ex.printStackTrace();
}
}
} 