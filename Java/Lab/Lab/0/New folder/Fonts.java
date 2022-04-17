import java.applet.Applet;
import java.awt.*;

public class Fonts extends Applet
 {
	String[] fontName1;
	String[] fontName2;
	
	public void init() {
		 
        GraphicsEnvironment graphicsEnvironment = GraphicsEnvironment.getLocalGraphicsEnvironment();
		fontName1 = graphicsEnvironment.getAvailableFontFamilyNames();
		
		Toolkit  t= Toolkit.getDefaultToolkit();
		fontName2  = t.getFontList();

    }
    public void paint(Graphics g) 
	{	
		int y = 20;
		
		for(int j = 0;j<fontName2.length;j++){
			Font f = new Font(fontName2[j], Font.BOLD, 20);
			g.setFont(f);
			g.drawString(fontName2[j], 300, y);
			y += 20;
		}
		
		for(int i = 0;i<fontName1.length;i++){
			Font f = new Font(fontName1[i], Font.BOLD, 20);
			g.setFont(f);
			g.drawString(fontName1[i], 0, y);
			y += 20;
		}
		
    }

}