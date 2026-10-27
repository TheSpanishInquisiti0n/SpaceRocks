package spacerocks.entities;

import java.awt.Graphics2D;

public class PowerUp extends Entity{
    private PowerEffect powerEffect;

    PowerUp(PowerEffect effect){
        super("/sprites/Null.png");
        this.powerEffect = effect;
    }

    @Override
    public boolean willWrap(){
        return true;
    }

    @Override
    public void draw(Graphics2D g){
        sprite.draw(g, x, y, theta);
    }

    public void doPower(){
        //for the strategy pattern, uses PowerEffect
    }
}

//gonna do a strategy pattern for this, I'll include
//files for the interface but probably not the subclasses
