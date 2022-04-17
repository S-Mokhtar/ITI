import java.applet.Applet;
import java.awt.Graphics;
import java.util.Date;

public class DateTime extends Applet implements Runnable {
    Date date;
    Thread th;

    public void start() {
        if (th == null) {
            th = new Thread(this);
            th.start();
        }
    }

    public void stop() {
        if (th != null) {
            th.stop();
            th = null;
        }
    }

    public void run() {
        while (true) {
            date = new Date();
            repaint();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            }
        }
    }

    public void paint(Graphics g) {
        g.drawString(date.toString(), 150, 300);
    }
}