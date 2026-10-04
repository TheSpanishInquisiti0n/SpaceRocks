package spacerocks.entities;

import java.awt.Graphics2D;

public class Player extends Entity {
    //added per tick
    private static double TURN_SPEED = 0.1;
    private static double THRUST = 0.15;
    private static double FRICTION = 0.5; //so things take a second to slow down
    public Player(){
        super();
    }
    public Player(double x,double y, double theta, double dx, double dy, double dtheta, double radius, String path){
        super(x,y,theta,dx,dy,dtheta,radius,path);
    }
    public void rotateLeft(){
        theta -= TURN_SPEED;
    }
    public void rotateRight(){
        theta += TURN_SPEED;
    }
    public void thrust(){
        dx+=Math.cos(theta)*THRUST;
        dy+=Math.sin(theta)*THRUST;
    }
    @Override 
    public void update(){
        dx *= FRICTION;
        dy*=FRICTION;
        super.update();
    }
    @Override
    public void draw(Graphics2D g){
        sprite.draw(g, x, y, theta);
    }
}
