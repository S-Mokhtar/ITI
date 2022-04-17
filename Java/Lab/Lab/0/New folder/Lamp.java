import java.applet.*;
import java.awt.*;

public class Lamp extends Applet{


	public void paint(Graphics g) {
		
		g.setColor(Color.yellow);
		g.fillOval(200, 190, 250, 60);

		g.setColor(Color.black);
		g.drawLine(200, 220, 160, 400);
		g.drawLine(450, 220, 495, 400);

		g.setColor(Color.yellow);
		g.fillOval(180, 320, 50, 80);	//left
		g.fillOval(275, 285, 100, 150);	//middle
		g.fillOval(420, 320, 50, 80);	//right
		
		g.setColor(Color.black);
		g.drawArc(160, 345, 335, 120, 170 , 200);
		
		g.drawLine(321, 465, 291, 560);
		g.drawLine(336, 465, 366, 560);
		
		g.drawLine(220, 560, 437, 560); //up
		g.drawLine(220, 560, 220, 580); //left
		g.drawLine(437, 560, 437, 580); //right
		g.drawLine(220, 580, 437, 580); //down	
		
	
	}
}
