import java.awt.*;
import java.awt.event.*;
import java.applet.*;

public class MovingBall extends Applet {
	int width = 150;
    	int height = 150;

	public void init(){
		this.addMouseListener(new MouseAdapter(){
			public void mousePressed(MouseEvent e){
				width = e.getX();
				height = e.getY();
				repaint();
			}
	
			public void mouseReleased(MouseEvent e){
				width = e.getX();
				height = e.getY();
				repaint();
			}
			
			public void mouseExited(MouseEvent e){}

			public void mouseEntered(MouseEvent e){}

			public void mouseClicked(MouseEvent e){}
			

		});

		this.addMouseMotionListener(new MouseAdapter(){
			public void mouseDragged(MouseEvent e){
				width = e.getX()-50;
				height = e.getY()-50;
				repaint();
			}
	
			public void mouseMoved(MouseEvent e) {}

		});
	}
    	public void paint(Graphics g){
        	g.fillOval( width, height, 100, 100);
    	}



	
}