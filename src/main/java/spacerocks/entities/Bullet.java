package spacerocks.entities;

import java.awt.Graphics2D;

public class Bullet extends Entity {
    public Bullet(){
        super();
    }
    @Override 
    public void draw(Graphics2D g){}

    public boolean willWrap(){
        return false;
    }

}
