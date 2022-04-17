import java.applet.Applet;
import java.awt.*;

public class movingText extends Applet implements Runnable{
	int x=100;

public void paint(Graphics g){
	g.drawString("Java World" , x, 100);
}

public void init(){
	Thread t = new Thread(this);
	t.start();
}

public void run(){
   while(true){
		if(x<getWidth()){
			x+=50;
		}
		else{
			x=0;
		}
		repaint();
		try{
			Thread.sleep(1000);
		}
		catch (InterruptedException ie){
			System.out.println(ie);
		}
	}
}
}

