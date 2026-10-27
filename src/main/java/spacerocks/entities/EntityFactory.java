//will be the catch all for generating everything on the screen

package spacerocks.entities;

import java.util.Random;

public class EntityFactory {
    private final Random random;

    public EntityFactory(Random random){
        this.random = random;
    }

    public Asteroid createAsteroid(){
        return new Asteroid(random);
    }
    public Ufo createUfo(){
        return new Ufo(random);
    }
    public PowerUp createPowerUp(PowerEffect effect){
        return new PowerUp(effect);
    }
}
