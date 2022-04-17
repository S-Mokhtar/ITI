import java.lang.Thread;
import java.awt.Graphics;
import java.awt.Color;
import java.applet.Applet;

public class MovingBall extends Applet implements Runnable {
  
  	int width = 150, height = 50, radius = 20;
  	int amountMovingX = 10;
	int amountMovingY = 10;
  
  	Thread thread;
	boolean isStop;

	public void init(){
		thread = new Thread(this);
		thread.start();
		isStop = false;
	}  

	public void paint(Graphics g) {
    		g.setColor(Color.red);
		g.fillOval( width-radius, height-radius, radius*2, radius*2);
  	}

 	public void run() {
    		while (true) {
     			 if (!isStop){
      				try {
				if( (width + radius + amountMovingX  >= getSize().width) ){
						width = getSize().width - radius;
						amountMovingX = -amountMovingX;
						width += amountMovingX;
				}

				if ( (width - radius + amountMovingX  <= 0) ){
						amountMovingX = -amountMovingX;	
				}
      				
				if( height + radius + amountMovingY >= getSize().height ){
						height = getSize().height - radius;
						amountMovingY = -amountMovingY;
						height += amountMovingY;
				}
				if ( height - radius + amountMovingY <= 0 ){
					amountMovingY = -amountMovingY ;	
				}
      				width += amountMovingX;
      				height += amountMovingY;
        				Thread.sleep(20);
      				} catch (Exception e) {
       			 		System.out.println(e);
      				};
      				
      				repaint();
			}else{
				break;
			}     
    		}
	}
}

