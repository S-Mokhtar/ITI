import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.net.*;
import java.io.*;

public class ChatClient extends JFrame implements Runnable {
	Socket mySocket;
	DataInputStream dis ;
	PrintStream ps;
	Thread th;
	
	JTextArea ta = new JTextArea(20,50);
	JScrollPane scroll = new JScrollPane(ta);
	JTextField tf = new JTextField(40);
	JButton okButton = new JButton("Send");
	public ChatClient(){
		this.setLayout(new FlowLayout());
		try
{
	mySocket = new Socket(InetAddress.getLocalHost(), 5005);
	dis = new DataInputStream(mySocket.getInputStream ());
	ps = new PrintStream(mySocket.getOutputStream ());
}
catch(IOException ex)
{
	ex.printStackTrace();
}
	okButton.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent ae){
			ps.println(tf.getText());
			tf.setText("");
		}
	});
	/*this.addWindowListener(new WindowAdapter() {
public void windowClosing(WindowEvent e) {
	close();
    System.exit(0);
}
  });
 
  this.setVisible(true);*/
	add(scroll);
	add(tf);
	add(okButton);
 th =new Thread(this);
		th.start();	
	}
	
void close(){
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
public void run() {
        while (true) {
		try
           { 
		     String str = dis.readLine();
			 ta.append(str +"\n");

		   }
	    catch (Exception ex)
	       {
            ex.printStackTrace();
           }
        }
		
    }
	
	public static void main(String args[]){
		ChatClient c=new ChatClient();
		c.setSize(600, 400);
		c.setResizable(false);
		c.setVisible(true);
	}
}