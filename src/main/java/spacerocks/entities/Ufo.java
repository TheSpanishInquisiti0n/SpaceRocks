package spacerocks.entities;

import java.awt.Graphics2D;

public class Ufo extends Enemy {
    public Ufo(){

    }
    @Override 
    public void draw(Graphics2D g){}

    @Override
    public boolean willWrap(){
        return true;
    }
}
