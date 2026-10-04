package spacerocks.states;

import java.awt.Graphics2D;

import spacerocks.SpaceRocks;
import spacerocks.entities.Player;

//this is the class we might put a builder on if we hate ourselves
public class PlayState implements GameState {
    private final SpaceRocks game;
    private final Player player;

    public PlayState(SpaceRocks game){
        this.game = game;
        this.player = new Player();
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
