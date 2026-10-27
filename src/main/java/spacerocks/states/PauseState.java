package spacerocks.states;

import java.awt.Graphics2D;

import spacerocks.GameContext;

public class PauseState implements GameState {
private final GameContext game;

    public PauseState(GameContext game){
        this.game = game;
    }

    @Override 
    public void update(){

    }
    
    @Override 
    public void draw(Graphics2D g){

    }

    @Override
    public void keyPressed(int keyCode){

    }

    @Override
    public void keyReleased(int keyCode){

    }
}
