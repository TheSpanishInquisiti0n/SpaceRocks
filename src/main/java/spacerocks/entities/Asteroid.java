package spacerocks.entities;

import java.util.Random;

public class Asteroid extends Enemy {
    public Asteroid(Random random){
        super("/sprites/Asteroid.png", random);
    }
}
