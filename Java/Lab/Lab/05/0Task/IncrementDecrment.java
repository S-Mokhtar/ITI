import java.awt.*;
import java.awt.event.*;
import java.applet.*;

public class IncrementDecrment extends Applet{
	int counter = 0;
    	public void init(){
        	Button increaseButton = new Button("Increase");
        	increaseButton.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					counter++;
        				repaint();
    				}
		});
        	add(increaseButton);

		Button decreaseButton = new Button("Decrease");
        	decreaseButton.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					counter--;
        				repaint();
    				}
		});
        	add( decreaseButton );
    	}

    	public void paint(Graphics g){
        	g.drawString("Total: " + counter, getWidth()/2, getHeight()/2);
    	}

	
}