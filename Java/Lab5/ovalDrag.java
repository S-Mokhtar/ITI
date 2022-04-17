import java.applet.*;
import java.awt.*;
import java.awt.event.*;  

public class ovalDrag extends Applet{
	int x = 150, y = 50, r = 20;
	public void init(){
		this.addMouseMotionListener(new ovalListener());
		this.addMouseListener(new ovalListener());
	}
	public void paint(Graphics g){
		g.fillOval(x, y, r * 2, r * 2);
	}
	class ovalListener extends MouseAdapter implements MouseMotionListener{
		public void mouseDragged(MouseEvent e){
			x=e.getX();
			y=e.getY();
			repaint();
		}
		public void mousePressed(MouseEvent e){
			x=e.getX();
			y=e.getY();
			repaint();
		}
		public void mouseMoved(MouseEvent e){}	
}	
}