import java.awt.*;
import java.applet.*;

public class MarqueeText extends Applet implements Runnable {
    private String word;
    private int x, y;
    Thread th;
    public void init() {
        word = "Java World";
        x = 0;
        y = 30;
        th = new Thread(this);
        th.start();
    }

    public void update() {
        x += 30;
        if (x > getWidth()){
            x = 0;
            y += 30;
        }
        if(y > getHeight()){
            y = 0;
            x = 0;
        }
    }
	
    public void run() {
        while (true) {
            repaint();
            update();
            try {
                Thread.sleep(100);
            } catch (InterruptedException ie) {
                System.out.println(ie);
            }
        }
    }
	
    public void paint(Graphics g) {
		Font f = new Font("Arial", Font.BOLD, 30);
		g.setFont(f);
		g.setColor(Color.RED);
        g.drawString(word, x, y);
    }
}