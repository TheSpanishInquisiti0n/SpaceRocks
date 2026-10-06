package spacerocks.entities;

import java.awt.Graphics2D;

import spacerocks.GamePanel;

public abstract class Entity {
    protected double x, y, theta;
    protected double dx, dy, dtheta;
    protected boolean alive = true;
    protected final HitBox hitBox;
    protected final Sprite sprite;
    //protected Constructor
    protected Entity(){
        x=GamePanel.WIDTH/2.0;
        y=GamePanel.HEIGHT/2.0;
        theta = 0.0;
        theta = 0.0;
        dx = 0.0;
        dy = 0.0;
        dtheta = 0.0;
        hitBox = new HitBox(this, 1);
        sprite = new Sprite("/sprites/Player.png",30,30);
    }

    protected Entity(double x, double y, double theta, double dx, double dy, double dtheta, double radius, String path){
        this.x = x;
        this.y = y;
        this.theta = theta;
        this.dx = dx;
        this.dy = dy;
        this.dtheta = dtheta;
        this.hitBox = new HitBox(this,radius);
        sprite = new Sprite(path,30,30);
    }
    //needs update method just x+dx, y+dy
    public void update(){
        x += dx;
        y+=dy;
        theta += dtheta;
        //wrap is gonna be problematic for bullet
        wrap();
    }

    public abstract void draw(Graphics2D g);

    public double getX(){
        return x;
    }

    public double getY(){
        return y;
    }

    public double getTheta(){
        return theta;
    }

    public HitBox getHitBox(){
        return hitBox;
    }

    public boolean isAlive(){
        return alive;
    }

    public void kill(){
        alive = false;
    }

    public void wrap(){
        //fix for wrap affecting bullet
        if(this.willWrap()){
            if(x<0){
            x+=GamePanel.WIDTH;
        }
        else if(x>GamePanel.WIDTH){
            x-=GamePanel.WIDTH;
        }
        if(y<0){
            y+=GamePanel.HEIGHT;
        }
        else if(y>GamePanel.HEIGHT){
            y-=GamePanel.HEIGHT;
        }
        }
    }

    public boolean collidesWith(Entity other){
        return hitBox.intersects(other.hitBox);
    }

    public abstract boolean willWrap();
}

