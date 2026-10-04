package spacerocks.entities;

import java.awt.Graphics2D;
import java.awt.geom.AffineTransform; //will explain in readme at some point
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;

public class Sprite{
    //I caved, having a sprite class is a good idea
    private static final Map<String, BufferedImage> cache = new HashMap<>();
    private final BufferedImage image;
    private final int width, height;

    public Sprite(String path, int width, int height){
        image = cache.computeIfAbsent(path, Sprite::load);
        this.width = width;
        this.height = height;
    }

    private static BufferedImage load(String path){
        try(InputStream in = Sprite.class.getResourceAsStream(path)){
            if(in==null){
                throw new IOException("file not found");
            }
            return ImageIO.read(in);
        } catch(IOException e){
            throw new RuntimeException("Couldn't load sprite " + path, e);
        }
    }

    public void draw(Graphics2D g, double x, double y, double theta){
        AffineTransform old = g.getTransform();
        g.translate(x, y);
        g.rotate(theta);
        g.drawImage(image, -width/2, -height/2,width,height,null);
        g.setTransform(old);
    }

    public int getWidth(){
        return image.getWidth();
    }

    public int getHeight(){
        return image.getHeight();
    }
}