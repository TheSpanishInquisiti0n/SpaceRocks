package spacerocks.entities;

import java.awt.Graphics2D;

public class Player extends Entity {
    public Player(){
        super();
    }
    public Player(double x,double y, double theta, double dx, double dy, double dtheta, double radius){
        super(x,y,theta,dx,dy,dtheta,radius);
    }

    @Override
    public void draw(Graphics2D g){}
}
