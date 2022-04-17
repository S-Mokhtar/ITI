import java.lang.Thread;
import java.awt.Graphics;
import java.util.Date;
import java.applet.Applet;

public class RunningTimer extends Applet implements Runnable{
	
	Thread thread;
	public void init(){
		thread = new Thread(this);
		thread.start();
	} 
	public void paint(Graphics g ){
		Date currentDate = new Date();
		g.drawString( currentDate.toString(), getSize().width/2 , getSize().height/2 );
		
	}	

	public void run(){
		while(true){
			try{
				repaint();
				thread.sleep(1000);
			}catch(InterruptedException ex) {
                        	ex.printStackTrace();
                    	}
		}
	}

}