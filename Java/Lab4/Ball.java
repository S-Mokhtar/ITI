import java.applet.*;
import java.awt.*;

public class Ball extends Applet implements Runnable{
	 int x = 150, y = 50, r = 20;
	 int dx=10,dy=8;
public void init(){
	Thread t = new Thread(this);
	t.start();
	}
public void paint(Graphics g){
	g.fillOval(x, y, r * 2, r * 2);
	}
public void run(){
	while(true){
	  if ((x + dx < 0) || (x + 2*r + dx > getWidth()))
			dx = -dx;
      if ((y + dy < 0) || (y + 2*r + dy > getHeight()))
		  dy = -dy;
      x += dx;
      y += dy;
	  repaint();
		try{
			Thread.sleep(100);
		}
		catch(InterruptedException ie){
			ie.printStackTrace();
		}
	}
}
}
