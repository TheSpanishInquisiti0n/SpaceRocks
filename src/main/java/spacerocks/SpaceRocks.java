package spacerocks;

import java.awt.Graphics2D;

import javax.swing.Timer;

public class SpaceRocks {
    public static final int FPS = 60;

    private final GameWindow window;
    private final Timer loop;

    public SpaceRocks(){
        window = new GameWindow(this); //SpaceRocks creates the window

        //main game loop, ~60 times a second (1000/60 = 16ms per frame)
        loop = new Timer(1000 / FPS, e -> {
            //update the current state here once states exist
            window.getPanel().repaint(); //redraws the panel (black background + draw())
        });
        loop.start();
    }

    //called by GamePanel, will draw the current state once states exist
    public void draw(Graphics2D g){}

    //called by GamePanel, will pass keys to the current state once states exist
    public void keyPressed(int keyCode){}

    public void keyReleased(int keyCode){}
}
