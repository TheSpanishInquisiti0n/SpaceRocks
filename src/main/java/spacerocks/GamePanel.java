package spacerocks;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;

//the screen and keyboard for the game, SpaceRocks owns the state and the loop
public class GamePanel extends JPanel implements KeyListener{
    public static final int WIDTH = 800;
    public static final int HEIGHT = 600;

    private final SpaceRocks game;

    public GamePanel(SpaceRocks game){
        this.game = game;
        setPreferredSize(new Dimension(WIDTH,HEIGHT));
        setBackground(Color.BLACK);
        setDoubleBuffered(true); //double buffering reduces flicker if there will be any
        setFocusable(true); //allows you to tab into the window
        addKeyListener(this);
    }

    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g); //paints the black background
        game.draw((Graphics2D) g); //SpaceRocks draws whatever the current state is
    }

    @Override public void keyPressed(KeyEvent e){game.keyPressed(e.getKeyCode());}

    @Override public void keyReleased(KeyEvent e){game.keyReleased(e.getKeyCode());}

    @Override public void keyTyped(KeyEvent e){}
}
