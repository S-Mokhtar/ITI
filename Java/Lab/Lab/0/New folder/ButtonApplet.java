import java.awt.*;
import java.awt.event.*;
import java.applet.*;

public class ButtonApplet extends Applet {

    Button buttonInc, buttonDec;
    int x=0;

    public void init(){

        buttonInc=new Button("Increment");
        buttonDec=new Button("Decrement");
        buttonInc.addActionListener(new MyButtonListener());
        buttonDec.addActionListener(new MyButtonListener());

        add(buttonInc);
        add(buttonDec);
    }

    public void paint(Graphics g){

        g.drawString("Count is : "+x,50,100);
    }
	class MyButtonListener implements ActionListener{ 
	
			public void actionPerformed(ActionEvent ev){

				if(ev.getSource() == buttonInc)
				{
					x++;
					repaint();
				}
				else if(ev.getSource() == buttonDec){
					x--;
					repaint();
				}
			}
	}
}