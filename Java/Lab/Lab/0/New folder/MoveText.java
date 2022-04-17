import java.awt.*;
import java.applet.*;
import java.awt.event.*;

public class MoveText extends Applet implements KeyListener
{
    int x = 200, y = 200;
	String word ;
    public void init ()
    {
    word = "Java";
    addKeyListener (this);
    } 
    public void paint (Graphics g)
    {
    	Font f = new Font("Arial", Font.BOLD, 30);
		g.setFont(f);
		g.setColor(Color.RED);
        g.drawString(word, x, y);
    } 
    public void keyPressed (KeyEvent e)
    {
    if (e.getKeyCode()==e.VK_UP )
    {
		if(y > 30)
        y = y-10;
    }
    if (e.getKeyCode()==e.VK_DOWN )
    {
		if(y < getHeight())
        y = y+10;
    }
    if (e.getKeyCode()==e.VK_LEFT)
    {
		if(x > 0)
        x = x-10;
    }
    if (e.getKeyCode()==e.VK_RIGHT)
    {
		if(x < (getWidth() - 70))
        x = x+10;
    }
    repaint ();
    }

    public void keyReleased (KeyEvent e){}
	public void keyTyped(KeyEvent e) {}

}