//okay so I was driving home and I thought this might be interesting
//every entity will have a hitbox object and then a sprite
//like most games, the hitbox will handle collisons
//the sprite will just be what is drawn
//sprite probably doesn't need to be its own class.
//as it's just a rendered image from the sprites folder
//just kinda bullshitting here, subject to change
package spacerocks.entities;

public class HitBox{
    private final Entity entity;
    private final double radius;


    protected HitBox(Entity entity, double radius){
        this.entity = entity;
        this.radius = radius;
    }

    public double getRadius(){
        return radius;
    }

    public boolean intersects(HitBox other){
        double distX = entity.getX() - other.entity.getX();
        double distY = entity.getY() - other.entity.getY();
        double radii = radius + other.radius;
        return distX*distX+distY*distY <= radii*radii;
    }
}