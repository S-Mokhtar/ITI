import java.lang.Thread;
import java.awt.Graphics;
import java.util.Date;
import java.applet.Applet;

public class MovingText extends Applet implements Runnable{
	int width = getSize().width/2;
	String text = "Moving Text Task is Done";
	int size = text.length();
	Thread thread;
	public void init(){
		thread = new Thread(this);
		thread.start();
	} 
	public void paint(Graphics g ){
		g.drawString( text, width - size/2, getSize().height/2 );
	}	

	public void run(){
		while(true){
			try{
				if( width+size >= getSize().width){
					width = 0;
				}
				width += size;
				repaint();
				thread.sleep(1000);
			}catch(InterruptedException ex) {
                        	ex.printStackTrace();
                    	}
		}
	}

}