import java.net.*;
import java.io.*;
import java.util.*;
class ChatHandler extends Thread{
	DataInputStream dis;
	PrintStream ps;
	static Vector<ChatHandler> clientsVector =new Vector<ChatHandler>();
	public ChatHandler(Socket cs){
		try{
			dis = new DataInputStream(cs.getInputStream());
			ps = new PrintStream(cs.getOutputStream());
			clientsVector.add(this);
			start();
		}
		catch (IOException e) {e.printStackTrace();}
	}
	public void run(){
		try{
			while(true){
				String str = dis.readLine();
				sendMessageToAll(str);
			}
		}
		catch (IOException e) {e.printStackTrace();}
	}
	void sendMessageToAll(String msg){
		for(ChatHandler ch : clientsVector){
			ch.ps.println(msg);
		}
	}
}