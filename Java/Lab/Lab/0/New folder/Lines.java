import java.applet.*;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class Lines extends Applet  {
    private final int maxLines = 3;
    private Point[] starts;
    private Point[] ends;
    private Point startPoint;
    private Point currentpoint;
    private int currentLines;
	boolean klick ;
  

    public void init() {
        starts = new Point[maxLines];
        ends = new Point[maxLines];
        currentLines = 0;
        
        this.addMouseListener(new MyButtonListener());
        this.addMouseMotionListener(new MyButtonListener());
    }
class MyButtonListener implements MouseListener, MouseMotionListener{


    public void mousePressed(MouseEvent e)
    {
        startPoint = new Point(e.getX(),e.getY());
        repaint();
    }


    public void mouseDragged(MouseEvent e)
    {
	    
        currentpoint = new Point(e.getX(),e.getY());
        repaint();
		klick =true;
    }
    public void mouseMoved(MouseEvent e) { }


    public void mouseReleased(MouseEvent e)
    {
        if (currentLines < maxLines && klick == true)
            addline(e.getX(),e.getY());
        else {
            
            currentpoint = null;
            repaint();
        }
    }
    public void mouseClicked(MouseEvent e) { }
    public void mouseEntered(MouseEvent e) { }
    public void mouseExited(MouseEvent e) { }

    void addline(int x, int y) {
        starts[currentLines] = startPoint;
        ends[currentLines] = currentpoint;
        currentLines++;
        currentpoint = null;
		klick = false; 
        repaint();
    }

}
    public void paint(Graphics g) {
       
         g.setColor(Color.blue);
        for (int i = 0 ; i < currentLines ; i++)
		 g.drawLine(starts[i].x,starts[i].y,ends[i].x,ends[i].y);     
    }

}