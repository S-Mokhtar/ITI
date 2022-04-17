import java.applet.Applet;  
import java.awt.Graphics;  
public class Task3 extends Applet{  
  
public void paint(Graphics g){ 
String str= getParameter("Hello World");
g.drawString(str,50, 50); 
}
}