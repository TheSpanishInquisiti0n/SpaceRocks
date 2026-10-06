package spacerocks.entities;

import java.awt.Graphics2D;
import java.util.Random;

public abstract class Enemy extends Entity {
    protected static double VELOCITY = 5; //not accel, constant
    protected final Random random;

    protected Enemy(String path){
        super(path);
        random = new Random();
        theta = random.nextDouble(2*Math.PI);
        //might write another constructor for entity, idk
        dx = VELOCITY*Math.cos(theta);
        dy = VELOCITY*Math.sin(theta);
    }

    @Override
    public void draw(Graphics2D g){
        sprite.draw(g,x,y,theta);
    } 

    @Override
    public void update(){
        super.update();
    }

    @Override 
    public boolean willWrap(){
        return true;
    }
}
