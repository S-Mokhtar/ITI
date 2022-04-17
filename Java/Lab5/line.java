import java.applet.*;
import java.awt.*;
import java.awt.event.*;  

public class line extends Applet{
	int x1,y1,x2,y2;
	public void init(){
		this.addMouseMotionListener(new lineListener());
		this.addMouseListener(new lineListener());
	}
	public void paint(Graphics g){
		g.drawLine(x1, y1, x2, y2);
	}
	class lineListener extends MouseAdapter implements MouseMotionListener{
		public void mouseDragged(MouseEvent e){
			x2=e.getX();
			y2=e.getY();
			repaint();
		}
		public void mousePressed(MouseEvent e){
			x1=e.getX();
			y1=e.getY();
		}
		/*public void mouseReleased(MouseEvent e){
			x1=e.getX();
			y1=e.getY();
		}*/	
}	
}