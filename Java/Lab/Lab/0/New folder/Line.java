import java.applet.*;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class Line extends Applet  {
  
    private Point startPoint,currentpoint;
   
  

    public void init() {
        
        this.addMouseListener(new MyButtonListener());
        this.addMouseMotionListener(new MyButtonListener());
    }
class MyButtonListener implements MouseListener, MouseMotionListener
{
	

		public void mousePressed(MouseEvent e)
		{
			startPoint = new Point(e.getX(),e.getY());
			repaint();
		}
		public void mouseDragged(MouseEvent e)
		{
			currentpoint = new Point(e.getX(),e.getY());
			repaint();
		}
		
		public void mouseReleased(MouseEvent e){}
		public void mouseMoved(MouseEvent e) { }
		public void mouseClicked(MouseEvent e) { }
		public void mouseEntered(MouseEvent e) { }
		public void mouseExited(MouseEvent e) { }	

}
    public void paint(Graphics g) {
       
       
		g.setColor(Color.blue);
         if (currentpoint != null)
            g.drawLine(startPoint.x,startPoint.y,currentpoint.x,currentpoint.y);
		
    }

} 