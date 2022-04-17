import java.applet.*;
import java.awt.*;

public class RandomBall extends Applet implements Runnable 
{
    int x = 150, y = 50, r = 20;
    int dx = 20, dy = 10;
 
    Thread th;
    boolean stopFlag;

  
    public void start() {
        th = new Thread(this);
        stopFlag = false;
        th.start();
    }

   
    public void paint(Graphics g) {
        g.setColor(Color.red);
        g.fillOval(x - r, y - r, r * 2, r * 2);
    }


    public void run() {
        while (true) {
            if (stopFlag)
                break;
			
		
			if( x - r + dx < 0)
			{
				dx = 20;
			}
          	else if (x + r + dx > getWidth() ){
				dx = -20;
			}
			
			if(y - r + dy < 0){
				dy = 10;
			} 
			else if(y + r + dy > getHeight()){
				dy = -10 ;
			} 
			
            x += dx;
            y += dy;

            try {
                Thread.sleep(100);
            } catch (Exception e) {
                System.out.println(e);
            }
            repaint();
        }
    }

    public void stop() {
        stopFlag = true;
        th = null;
    }
}