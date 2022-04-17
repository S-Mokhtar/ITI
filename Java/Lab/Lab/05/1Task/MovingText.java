import java.awt.*;
import java.awt.event.*;
import java.applet.*;

public class MovingText extends Applet /*implements KeyListener*/{
	int width = 150;
    	int height = 150;

	String text = "Hello";
	int size = text.length();

	public void init(){
		this.addKeyListener(new KeyListener(){
			public void keyPressed(KeyEvent e){
				switch( e.getKeyCode() ){
					case KeyEvent.VK_UP:
						if(height > 10)
							height -= 5;
						repaint();
						break;

					case KeyEvent.VK_DOWN:
						if(height < getHeight() )
							height += 5;
						repaint();
						break;

					case KeyEvent.VK_RIGHT:
						if(width < getWidth()- (size*size + 5) )
							width += size;
						repaint();
						break;

					case KeyEvent.VK_LEFT:
						if(width > 0)
							width -= size;
						repaint();
						break;
				}
			}
	
			public void keyReleased(KeyEvent e){}

			public void keyTyped(KeyEvent e){}

		//This end of this
		});
	}
    	public void paint(Graphics g){
        	g.drawString(text, width, height);
    	}

/*	public void keyPressed(KeyEvent e){
		switch( e.getKeyCode() ){
			case KeyEvent.VK_UP:
				height += 100;
				repaint();
				break;

			case KeyEvent.VK_DOWN:
				height -= 100;
				repaint();
				break;

			case KeyEvent.VK_RIGHT:
				width += 100;
				repaint();
				break;

			case KeyEvent.VK_LEFT:
				height -= 100;
				repaint();
				break;
		}
		
	}
	
	public void keyReleased(KeyEvent e){
		
	}

	public void keyTyped(KeyEvent e){
		
	}
*/

	
}