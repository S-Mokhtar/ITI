import java.awt.Toolkit;
import java.awt.Font;
import java.awt.GraphicsEnvironment;

class FontClass{

	public static void main(String[] args){
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		String[] fonts = toolkit.getFontList();
		
		for(String font : fonts){
			System.out.println( Font.getFont(font) );
		}	

		GraphicsEnvironment graphics = GraphicsEnvironment.getLocalGraphicsEnvironment();
		Font[] fontsArray /*fonts*/ = graphics.getAllFonts();
		
		for(Font font : fontsArray){
			System.out.println( Font.getFont( font.getFontName() ) );
		}
		
	}

}