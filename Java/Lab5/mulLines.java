import java.applet.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;   

public class mulLines extends Applet{
	ArrayList<points> points=new ArrayList<points>();
	Point p1=new Point();
	Point p2=new Point();
	public void init(){
		this.addMouseMotionListener(new lineListener());
		this.addMouseListener(new lineListener());
	}
	
	public void paint(Graphics g){
		for(points pt: points)
			g.drawLine(pt.po1.x,pt.po1.y,pt.po2.x,pt.po2.y);
	}
	
	class lineListener extends MouseAdapter implements MouseMotionListener{
		public void mouseDragged(MouseEvent e){
			points pt=points.get(points.size()-1);
			pt.setP2(e.getPoint());
			//p2=e.getPoint();
			repaint();
		}
		public void mousePressed(MouseEvent e){
			
			p1=e.getPoint();
			points po=new points(p1,p2);
			System.out.println(p1.getX() + "");
			points.add(po);
		}
		public void mouseReleased(MouseEvent e){
			points pt=points.get(points.size()-1);
			pt.setP2(e.getPoint());
		}
		public void mouseMoved(MouseEvent e){}

}	
	class points {
			Point po1=new Point();
			Point po2=new Point();;
			points(Point point1,Point point2){
				po1=point1;
				po2=point2;
			}
			void setP2(Point pt){
				po2=pt;
			}
	}
}