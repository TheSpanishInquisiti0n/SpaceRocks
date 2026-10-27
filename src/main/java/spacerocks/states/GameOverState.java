package spacerocks.states;

import java.awt.Graphics2D;
import java.awt.event.KeyEvent;

import spacerocks.GameContext;

public class GameOverState implements GameState {
private final GameContext game;
private final int score;

    public GameOverState(GameContext game, int score){
        this.game = game;
        this.score = score; // will be inherited from play state
    }

    @Override 
    public void update(){

    }
    
    @Override 
    public void draw(Graphics2D g){

    }

    @Override
    public void keyPressed(int keyCode){
        switch(keyCode){
            case KeyEvent.VK_ENTER -> game.setState(new TitleState(game));
            case KeyEvent.VK_ESCAPE -> game.quit();

        }
    }

    @Override
    public void keyReleased(int keyCode){
        //wont need anything.
    }
}
