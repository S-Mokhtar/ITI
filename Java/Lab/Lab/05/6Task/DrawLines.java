import java.applet.Applet;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.event.*;
import java.util.*;


public class DrawLines extends Applet {

  int currentXStart;
  int currentYStart;
  int currentXEnd;
  int currentYEnd;
  boolean isPressed;
  List<SavedPoints> list;


  class SavedPoints{
    int startPostionX;
    int startPostionY;
    int endPostionX;
    int endPostionY;
  }

  public void init(){

    isPressed = false ;
    list = new ArrayList<SavedPoints>();

      this.addMouseListener(new MouseListener(){

                    
                    public void mousePressed(MouseEvent e){

                        isPressed = true ;
                        currentXStart = e.getX() ;
                        currentYStart = e.getY() ;
                    }
                  
                    public void mouseReleased(MouseEvent e){

                      currentXEnd = e.getX() ;
                      currentYEnd = e.getY() ;
                      if( currentXStart != currentXEnd && currentYStart != currentYEnd ){

                          isPressed = false ;
                          SavedPoints line = new SavedPoints();
                          line.startPostionX = currentXStart ;
                          line.startPostionY = currentYStart ;
                          line.endPostionX = currentXEnd  ;
                          line.endPostionY = currentYEnd  ;
                          list.add(line);
                          repaint();

                      }


                    }
                    
                    public void mouseClicked(MouseEvent e){}
                    
                    public void mouseEntered(MouseEvent e){ }
                   
                    public void mouseExited(MouseEvent e){ }
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
     

      for(SavedPoints savedLine:list){
        g.drawLine( savedLine.startPostionX , savedLine.startPostionY ,savedLine.endPostionX , savedLine.endPostionY );
      }

        g.drawLine( currentXStart , currentYStart ,currentXEnd , currentYEnd );

  }

}



