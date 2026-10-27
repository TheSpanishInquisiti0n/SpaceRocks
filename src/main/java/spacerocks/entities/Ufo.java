package spacerocks.entities;

import java.util.Random;

public class Ufo extends Enemy {
    private Random random;

    public Ufo(){
        //the "new"s will disappear in like 4 commits max dont worry
        super("/sprites/Ufo2.png", new Random());
    }
}
