import java.applet.Applet;
import java.awt.Graphics;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.GraphicsEnvironment;
import java.awt.Color;

public class AppletClass extends Applet{

	public void init(){
		}

	public void paint(Graphics g){
		//g.drawArc(10,10,50,100,180,45);
		g.setColor(Color.yellow);
		g.fillOval(100,20, 250,50);
		
		g.fillOval(100,120, 40,70);
		g.fillOval(200,100, 70,150);
		g.fillOval(320,120, 40,70);

		g.setColor(Color.black);
		g.drawLine(100,50,50,250);
		g.drawLine(350,50,420,250);

		g.drawArc(50,225,368,50,180,180);

		g.drawLine(230,275,190,400);
		g.drawLine(250,275,290,400);

		g.drawRect(140,400,200,50);
		}

}