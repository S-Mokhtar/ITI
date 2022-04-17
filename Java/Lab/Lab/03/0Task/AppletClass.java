import java.awt.Toolkit;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.applet.Applet;  
import java.awt.Graphics; 

public class AppletClass extends Applet{

	public void paint(Graphics g){
		Font f;
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		String[] fonts = toolkit.getFontList();
		int i = 1;
		for(String font : fonts){
			f = new Font( font, Font.BOLD, 20 );
			// Font.getFont(font);
			g.setFont(f);
			g.drawString(  font, 150, i);
			i += 15;
			
		}	

		GraphicsEnvironment graphics = GraphicsEnvironment.getLocalGraphicsEnvironment();
		Font[] fontsArray = graphics.getAllFonts();
		
		for(Font font : fontsArray){
			f =new Font( font.getFontName(), Font.BOLD, 20 );
			// Font.getFont( font.getFontName() );
			g.setFont(f );
			g.drawString( font.getFontName() , 150, i);
			i += 15;
		}
	}
	

}