//will be the catch all for generating everything on the screen

package spacerocks.entities;

public class EntityFactory {
    public Asteroid createAsteroid(){
        return new Asteroid();
    }
    public Ufo createUfo(){
        return new Ufo();
    }
    public PowerUp creatPowerUp(){
        return new PowerUp();
    }
}