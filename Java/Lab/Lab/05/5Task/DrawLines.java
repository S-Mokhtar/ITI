import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;


public class DrawLines extends Applet {

  int currentXStart;
  int currentYStart;
  int currentXEnd;
  int currentYEnd;
  boolean isPressed;
  int lineCounter = 0;


  class SavedPoints{
    int startPostionX;
    int startPostionY;
    int endPostionX;
    int endPostionY;
  }

  SavedPoints[] point = new SavedPoints[3];;
  int currentLinesCounter;



  public void init(){

    isPressed = false ;

      this.addMouseListener(new MouseListener(){
                    
                    public void mousePressed(MouseEvent e){
                      if(lineCounter < 3){
                        isPressed = true ;
                        currentXStart = e.getX() ;
                        currentYStart = e.getY() ;                  
                      }
                    }
                  
                    public void mouseReleased(MouseEvent e){
                     

                      currentXEnd = e.getX() ;
                      currentYEnd = e.getY() ;
                      if( currentXStart != currentXEnd && currentYStart != currentYEnd ){
                        if(lineCounter < 3){
                           isPressed = false ;
                          SavedPoints line = new SavedPoints();
                          line.startPostionX = currentXStart ;
                          line.startPostionY = currentYStart ;
                          line.endPostionX = currentXEnd  ;
                          line.endPostionY = currentYEnd  ;
                          point[lineCounter] = line;
                          repaint();
                          lineCounter++;

                        }


                      }


                    }
                   
                    public void mouseClicked(MouseEvent e){}
                  
                    public void mouseEntered(MouseEvent e){}
                  
                    public void mouseExited(MouseEvent e){}


      });

      this.addMouseMotionListener(new MouseMotionListener(){

                   
                    public void mouseMoved(MouseEvent e){}
                   
                    public void mouseDragged(MouseEvent e){
                      if( isPressed == true){
                         currentXEnd = e.getX() ;
                         currentYEnd = e.getY() ;
                       
                         if(( currentXStart != currentXEnd ) && ( currentYStart  != currentYEnd) ){
                          repaint();
                        }
                      }
                    }
      });


    }

  public void paint(Graphics g){
    
      for(int i = 0 ; i < lineCounter ; i++){
        g.drawLine( point[i].startPostionX  , point[i].startPostionY ,point[i].endPostionX , point[i].endPostionY );
      }
	g.drawLine( currentXStart , currentYStart ,currentXEnd , currentYEnd );
  }

}
