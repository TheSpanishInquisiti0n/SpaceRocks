package spacerocks.entities;

import java.awt.Graphics2D;

public class PowerUp extends Entity{
    //lowkey might wanna do 
    PowerUp(){
        super();
    }

    @Override
    public boolean willWrap(){
        return true;
    }

    @Override 
    public void draw(Graphics2D g){
        //needs to be implemented
    }

    public void doPower(){
        //for the strategy pattern
    }
}

//gonna do a strategy pattern for this, I'll include
//files for the interface but probably not the subclasses
