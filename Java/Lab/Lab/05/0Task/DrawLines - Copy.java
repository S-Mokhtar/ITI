import java.awt.*;
import java.awt.event.*;
import java.applet.*;

public class DrawLines extends Applet {
	int startPostionX ;
    	int startPostionY;
	int endPostionX ;
    	int endPostionY;
	boolean isPresed = false;
	Line[] line = new Line[3];
	int counter = 0;
	public void init(){
		Adapter adpter = new Adapter();
		this.addMouseListener(adpter);

		
		this.addMouseMotionListener(adpter);
	}
    	public void paint(Graphics g){
		for(int i =0; i < 3; i++){
			if(line[i] != null)	
				g.drawLine( line[i].startPostionX, line[i].startPostionY, line[i].endPostionX, line[i].endPostionY);
		}
	/*	if(firstLine != null)	
			g.drawLine( firstLine.startPostionX, firstLine.startPostionY, firstLine.endPostionX, firstLine.endPostionY);
		if(secondLine != null)	
			g.drawLine( secondLine.startPostionX, secondLine.startPostionY, secondLine.endPostionX, secondLine.endPostionY);
		if(thirdLine != null)
			g.drawLine( thirdLine.startPostionX, thirdLine.startPostionY, thirdLine.endPostionX, thirdLine.endPostionY);
        	*/
    	}

	class Line{
		public int startPostionX ;
    		public int startPostionY;
		public int endPostionX ;
    		public int endPostionY;
		Line(int startX, int startY, int endX, int endY){
			 startPostionX = startX ;
    			 startPostionY = startY;
			 endPostionX = endX;
    			 endPostionY = endY;
		}
	}

	class Adapter extends MouseAdapter{
		public void mouseDragged(MouseEvent e){
			if(thirdLine != null){
				thirdLine.endPostionX = e.getX();
				thirdLine.endPostionY = e.getY();
			}else{
				if(secondLine != null){
					secondLine.endPostionX = e.getX();
					secondLine.endPostionY = e.getY();
				}else if(firstLine != null){
					firstLine.endPostionX = e.getX();
					firstLine.endPostionY = e.getY();
				}
			}
				
			repaint();
		}

		public void mousePressed(MouseEvent e){
			/*if( thirdLine != null)
				firstLine = secondLine = thirdLine = null;				

			if(firstLine == null){
				firstLine = new Line(e.getX(), e.getY(), e.getX(), e.getY());
				secondLine = null;thirdLine = null;
			} else {
				if(secondLine == null){
					secondLine = new Line(e.getX(), e.getY(), e.getX(), e.getY());
					thirdLine = null;
				} else {
					if( thirdLine == null){
						thirdLine = new Line(e.getX(), e.getY(), e.getX(), e.getY());
					}
				}
			}*/
			isPresed = true;
			startPostionX = e.getX();
			startPostionY = e.getY();
		}
		public void mouseReleased(MouseEvent e){
			if(isPresed == true){
			/*if( thirdLine != null)
				firstLine = secondLine = thirdLine = null;				
*/
			if(firstLine == null){
				firstLine = new Line(startPostionX , startPostionY , e.getX(), e.getY() );
				//secondLine = null;thirdLine = null;
			} else {
				if(secondLine == null){
					secondLine = new Line(startPostionX ,startPostionY , e.getX(), e.getY() );
				//	thirdLine = null;
				} else {
					if( thirdLine == null){
						thirdLine = new Line(startPostionX , startPostionY , endPostionX, endPostionY);
					}
				}
			}
			}
		}
	}
	
}