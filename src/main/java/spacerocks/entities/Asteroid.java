package spacerocks.entities;

public class Asteroid extends Enemy {
    //public Asteriod(){}

    @Override 
    public boolean willWrap(){
        return true;
    }
}
