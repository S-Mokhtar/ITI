import java.net.*;
import java.io.*;
public class Client
{
	Socket mySocket;
	DataInputStream dis ;
	PrintStream ps;
public static void main(String[] args)
{
new Client();
}
public Client()
{
try
{
	mySocket = new Socket(InetAddress.getLocalHost(), 5005);
	dis = new DataInputStream(mySocket.getInputStream ());
	ps = new PrintStream(mySocket.getOutputStream ());
	ps.println("Test Test");
	String replyMsg = dis.readLine();
	System.out.println(replyMsg);
}
catch(IOException ex)
{
	ex.printStackTrace();
}
try
{
	ps.close();
	dis.close();
	mySocket.close();
}
catch(Exception ex)
{
	ex.printStackTrace();
}
}
}