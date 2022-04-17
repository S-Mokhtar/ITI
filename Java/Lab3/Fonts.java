import java.awt.*;
import java.applet.*;

public class Fonts extends Applet{

public void paint(Graphics g){ 
    String fonts1[] =GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
	String fonts2[] =Toolkit.getDefaultToolkit().getFontList();
    for (int i=0; i<fonts1.length; i++ ){
	  Font f = new Font(fonts1[i], Font.BOLD, 14);
	  g.setFont(f);
	  g.drawString(fonts1[i],50,(100+(10*i)));
    }
	/*for (int i=0; i<fonts2.length; i++ ){
	  Font f2 = new Font(fonts2[i], Font.BOLD, 14);
	  g.setFont(f2);
	  g.drawString(fonts2[i],50,(100+(10*i)));
    }*/
  }

}
