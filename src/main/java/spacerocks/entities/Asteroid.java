package spacerocks.entities;

import java.util.Random;

public class Asteroid extends Enemy {
    private Random random;

    public Asteroid(){
        super("/sprites/Asteroid.png", new Random());
    }
}
