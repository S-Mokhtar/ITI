import java.applet.*;
import java.awt.*;

public class Lamb extends Applet{
	
	public void paint(Graphics g){
		Color c = new Color(255,255,150);
		
		
		int xarc = 27, yarc = 100, warc=298, harc=170;
		int xo = 80, yo=0, wo=200, ho=60;
		
		g.setColor(Color.RED);
         g.drawArc(xarc,yarc,warc,harc,0,-180);
		 g.drawRect(60,320,240,25);
		
		g.setColor(Color.BLUE);
		 g.drawLine(xo, ho/2, xarc, yarc + harc/2);
         g.drawLine(xo+wo, ho/2, xarc+warc, yarc+harc/2);
		 
		 g.setColor(Color.GREEN);
         g.drawLine(140, 270, 120, 320);
         g.drawLine(210, 270, 235, 320);
		 
		 g.setColor(c);
		 g.fillOval(xo, yo, wo, ho);
	     g.fillOval(60,100, 50,100);
		 g.setColor(Color.ORANGE);
	     g.fillOval(250,100, 50,100);
	     g.fillOval(150,100, 70,130);
         
}
}