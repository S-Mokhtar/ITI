import java.awt.*;
import java.awt.event.*;
import java.applet.*;

public class DrawLine extends Applet {
	int startPostionX ;
    	int startPostionY;
	int endPostionX ;
    	int endPostionY;

	public void init(){
		this.addMouseListener(new MouseAdapter(){
			
			public void mousePressed(MouseEvent e){
				startPostionX = endPostionX = e.getX();
				startPostionY = endPostionY = e.getY();
				repaint();
			}			

		});

		this.addMouseMotionListener(new MouseAdapter(){
			public void mouseDragged(MouseEvent e){
				endPostionX = e.getX();
				endPostionY = e.getY();
				repaint();
			}

		});
	}
    	public void paint(Graphics g){
        	g.drawLine( startPostionX, startPostionY, endPostionX, endPostionY);
    	}



	
}