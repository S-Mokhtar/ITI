import java.applet.Applet;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.TextField;
import java.awt.Graphics;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
public class movingText extends Applet implements KeyListener{
	int x=100;
	int y=100;
	public void paint(Graphics g){
		g.drawString("Java" , x, y);
	}
	public void init(){
		addKeyListener(this);
	}
	public void keyPressed(KeyEvent e) {
		int keyPressed= e.getKeyCode();
		switch(keyPressed){
		case KeyEvent.VK_RIGHT:
			x+=50;
			repaint();
			break;
		case KeyEvent.VK_LEFT:
			x-=50;
			repaint() ;
			break;
		case KeyEvent.VK_UP:
			y-=50;
			repaint() ;
			break;
		case KeyEvent.VK_DOWN :
			y+=50;
			repaint() ;
			break;
		}
	}
	public void keyReleased(KeyEvent e){}
	public void keyTyped(KeyEvent e){}
}