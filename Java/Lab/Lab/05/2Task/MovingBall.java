import java.lang.Thread;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.*;
import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;
import java.applet.*;

public class MovingBall extends Applet /*implements Runnable*/ {
  
  	int width = 150, height = 50, radius = 20;
  	int amountMovingX = 10;
	int amountMovingY = 10;
  
  	Thread thread;
	boolean isStop = true;

	public void init(){
		Button start = new Button("Start");
		Button stop = new Button("Stop");
		stop.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ev){
				isStop = true;
			}});
		add(stop);
		start.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ev){
			if(isStop == true){
			isStop = false;
			Thread th = new Thread(new Runnable(){
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
				}});
			th.start();
			}}
		});
		/*thread = new Thread(this);
		thread.start();
		isStop = false;*/
		add(start);
	}  

	public void paint(Graphics g) {
    		g.setColor(Color.red);
		g.fillOval( width-radius, height-radius, radius*2, radius*2);
  	}

 	
}

