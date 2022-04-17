import java.awt.*;
import java.applet.*;

public class image extends Applet {
    Image img;
    public void init() {
        img = getImage(getDocumentBase(), "image.jpg");
    }
    public void paint(Graphics g) {
        g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
	}
	}
   