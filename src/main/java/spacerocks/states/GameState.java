package spacerocks.states;

import java.awt.Graphics2D;

public interface GameState{
    //interface for all the individual states, each will implement this
    void update(); //does all the movement and collision checks 60 times/s
    void draw(Graphics2D g); //draws the screen for each state
    void keyPressed(int keyCode);
    void keyReleased(int keyCode);
}