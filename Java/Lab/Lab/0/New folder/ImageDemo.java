import java.awt.*;
import java.applet.*;


public class ImageDemo extends Applet {
	
    Image picture;
    public void paint(Graphics g){
		picture =getImage(getCodeBase(),"1.png");
		int width = getWidth()/2;
		int height =getHeight()/2;
		g.drawImage(picture, 20 , 20, width, height, this);
	 
    }

}