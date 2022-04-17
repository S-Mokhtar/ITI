import java.awt.*;
import java.awt.event.*;
import java.awt.Graphics;
import java.applet.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SPBall extends Applet implements Runnable {
	Thread t;
	Boolean move = true;
	Button b1;
	Button b2;
	int x=150;
	int y=50;
	int r = 20;
	int dx=10,dy=8;
	public void init(){
		t = new Thread(this);
		Button b1 = new Button("Start");
		Button b2 = new Button("pause");
		add(b1);
		add(b2);
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				if(move==true)
					t.start();
				else
					t.resume();
			}
		});
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				t.suspend();
				move=false;
			}
		});
	}
	public void paint(Graphics g){
		g.fillOval(x, y, r*2, r*2);
	}
	public void run(){
		while(true){
			if ((x + dx < 0) || (x + 2*r + dx > getWidth()))
				dx = -dx;
			if ((y + dy < 0) || (y + 2*r + dy > getHeight()))
				dy = -dy;
			x += dx;
			y += dy;
			repaint();
			try{Thread.sleep(100);}
			catch(InterruptedException ie){ie.printStackTrace();}
		}
	}
}