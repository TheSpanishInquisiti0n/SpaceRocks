package spacerocks.entities;

import java.awt.Graphics2D;
import java.util.Random;

public abstract class Enemy extends Entity {
    protected static double VELOCITY = 5; //not accel, constant
    protected final Random random;

    protected Enemy(String path, Random random){
        super(path);
        //for tests
        this.random = random;
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

//I'm thinking a stratgy pattern might work for special enemies
//just like in powerup but maybe all the special entites
//just get a super call with the thing changed
//whatever ends up being the cleanest to implement
//gonna delete the placeholder files Until I decide
