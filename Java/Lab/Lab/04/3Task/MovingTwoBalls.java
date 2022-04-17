import java.lang.Thread;
import java.awt.Graphics;
import java.awt.Color;
import java.applet.Applet;

public class MovingTwoBalls extends Applet implements Runnable {
  
  	int width1 = 150, height1 = 50, radius = 20, width2 = getWidth()/2, height2 = getHeight()/2;
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
		g.fillOval( width1-radius, height1-radius, radius*2, radius*2);
		g.setColor(Color.black);
		g.fillOval( width2-radius, height2-radius, radius*2, radius*2);
  	}

 	public void run() {
    		while (true) {
     			 if (!isStop){
      				try {
				//First Ball
				if( (width1 + radius + amountMovingX  >= getSize().width) ){
						width1 = getSize().width - radius;
						amountMovingX = -amountMovingX;
						width1 += amountMovingX;
				}

				if ( (width1 - radius + amountMovingX  <= 0) ){
						amountMovingX = -amountMovingX;	
				}
      				
				if( height1 + radius + amountMovingY >= getSize().height ){
						height1 = getSize().height - radius;
						amountMovingY = -amountMovingY;
						height1 += amountMovingY;
				}
				if ( height1 - radius + amountMovingY <= 0 ){
					amountMovingY = -amountMovingY ;	
				}

				//Second Ball
				if( (width2 + radius + amountMovingX  >= getSize().width) ){
						width2 = getSize().width - radius;
						amountMovingX = -amountMovingX;
						width2 += amountMovingX;
				}

				if ( (width2 - radius + amountMovingX  <= 0) ){
						amountMovingX = -amountMovingX;	
				}
      				
				if( height2 + radius + amountMovingY >= getSize().height ){
						height2 = getSize().height - radius;
						amountMovingY = -amountMovingY;
						height2 += amountMovingY;
				}
				if ( height2 - radius + amountMovingY <= 0 ){
					amountMovingY = -amountMovingY ;	
				}

      				width1 += amountMovingX;
      				height1 += amountMovingY;
				width2 += amountMovingX+20;
      				height2 += amountMovingY+20;

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

