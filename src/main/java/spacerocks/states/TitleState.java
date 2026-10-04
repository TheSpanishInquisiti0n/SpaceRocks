package spacerocks.states;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;

import spacerocks.Fonts;
import spacerocks.GamePanel;
import spacerocks.SpaceRocks;

public class TitleState implements GameState {
    private final SpaceRocks game;

    public TitleState(SpaceRocks game){
        this.game = game;
    }

    @Override 
    public void update(){
        //title screen wont have any moving objects
    }
    
    @Override 
    public void draw(Graphics2D g){
        g.setColor(Color.BLACK);
        //total gamble if hyper space works, I hope it does
        g.setColor(Color.WHITE);
        g.setFont(Fonts.HYPERSPACE_BOLD.deriveFont(48f));
        g.drawString("SPACE ROCKS", GamePanel.WIDTH/2-160, GamePanel.HEIGHT/2-40);

        g.setFont(Fonts.HYPERSPACE.deriveFont(20f));
        g.drawString("Press Enter to start", GamePanel.WIDTH/2-120, GamePanel.HEIGHT/2+20);
    }

    @Override
    public void keyPressed(int keyCode){
        if(keyCode ==KeyEvent.VK_ENTER){
            game.setState(new PlayState(game));
        }
    }

    @Override
    public void keyReleased(int keyCode){
        //wont need this
    }
}
