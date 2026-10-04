package spacerocks.states;

import java.awt.Graphics2D;

import spacerocks.SpaceRocks;

public class GameOverState implements GameState {
private final SpaceRocks game;

    public GameOverState(SpaceRocks game){
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
