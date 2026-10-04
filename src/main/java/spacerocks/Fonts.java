//helper class for loading the font
package spacerocks;

import java.awt.Font;
import java.awt.FontFormatException;
import java.io.IOException;
import java.io.InputStream;

public class Fonts{
    public static final Font HYPERSPACE = load("/fonts/Hyperspace.otf");
    public static final Font HYPERSPACE_BOLD = load("/fonts/Hyperspace Bold.otf");

    private static Font load(String path){
        try(InputStream in = Fonts.class.getResourceAsStream(path)){
            return Font.createFont(Font.TRUETYPE_FONT, in);
        }
        catch(IOException | FontFormatException | NullPointerException e){
            System.err.println("Couldn't load font "+path+", using Monospaced");
            return new Font("Monospaced", Font.PLAIN, 12);
        }
    }
}