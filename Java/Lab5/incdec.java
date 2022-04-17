import java.applet.Applet;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class incdec extends Applet{
	int count;
	Button inc;
	Button dec;
	public void init(){
		inc = new Button("Increment");
		inc.addActionListener(new MyButtonListener());
		add(inc);
		dec = new Button("Decrement");
		dec.addActionListener(new MyButtonListener2());
		add(dec);
	}
	public void paint(Graphics g){
		g.drawString("Count is:" + count, 50, 200);
	}
	class MyButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent ev){
			count++ ;
			repaint() ;
		}
	}
	class MyButtonListener2 implements ActionListener{
		public void actionPerformed(ActionEvent ev){
			count-- ;
			repaint() ;
		}
	}
}
