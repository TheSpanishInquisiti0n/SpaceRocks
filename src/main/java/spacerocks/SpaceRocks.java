package spacerocks;

import java.awt.Graphics2D;

import javax.swing.Timer;

import spacerocks.states.GameState;
import spacerocks.states.TitleState;

public class SpaceRocks {
    public static final int FPS = 60;

    private final GameWindow window;
    private final Timer loop;
    private GameState currentState;

    public SpaceRocks(){
        currentState = new TitleState(this);
        window = new GameWindow(this); //SpaceRocks creates the window

        //main game loop, ~60 times a second (1000/60 = 16ms per frame)
        loop = new Timer(1000 / FPS, e -> {
            currentState.update();
            window.getPanel().repaint();

        });
        loop.start();
    }

    public void setState(GameState nexState){
        currentState = nexState;
    }

    //called by GamePanel, will draw the current state once states exist
    public void draw(Graphics2D g){
        currentState.draw(g);
    }

    //called by GamePanel, will pass keys to the current state once states exist
    public void keyPressed(int keyCode){
        currentState.keyPressed(keyCode);
    }

    public void keyReleased(int keyCode){
        currentState.keyPressed(keyCode);
    }
}
