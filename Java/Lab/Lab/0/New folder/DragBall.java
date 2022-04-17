import java.applet.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
public class DragBall extends Applet
{
    int x =400;
	int y = 200;
	int xposR;
	int yposR;
	boolean mousedrag;
	MyButtonListener mybuttonlistener;
    public void paint(Graphics g) {
	
		if(mousedrag ==true)
		{
			x=xposR;
			y=yposR;
		}
        g.setColor(Color.blue);
        g.fillOval(x, y,60, 60);
    }
	
    public void init() 
	{
      this.addMouseMotionListener(new MyButtonListener());
	}
class MyButtonListener implements  MouseMotionListener
{
	
		public void mouseDragged(MouseEvent e)
		{ 
		mousedrag =true;
		xposR = e.getX();
        yposR = e.getY();
        repaint();	
		
		}
		public void mouseMoved(MouseEvent e) { }
}


  
}