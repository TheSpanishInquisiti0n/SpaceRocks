package spacerocks.states;

import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import spacerocks.GameContext;
import spacerocks.entities.Entity;
import spacerocks.entities.EntityFactory;
import spacerocks.entities.Player;

//this is the class we might put a builder on if we hate ourselves
public class PlayState implements GameState {
    private final GameContext game;
    private final EntityFactory factory;
    private final Player player;
    private final List<Entity> entities;
    //for keys
    private boolean  up, left, right;


    public PlayState(GameContext game, EntityFactory factory){
        this.game = game;
        this.factory = factory;
        //not final, just for testing as we work through this
        player = new Player();
        entities = new ArrayList<>();
        entities.add(factory.createUfo());
        entities.add(factory.createAsteroid());
    }

    @Override 
    public void update(){
        if(left){
            player.rotateLeft();
        }
        if(right){
            player.rotateRight();
        }
        if(up){
            player.thrust();
        }
        for(Entity entity:entities){
            entity.update();
        }
        player.update();
    }
    
    @Override 
    public void draw(Graphics2D g){
        player.draw(g);
        for(Entity entity:entities){
            entity.draw(g);
        }
    }

    @Override
    public void keyPressed(int keyCode){
        switch(keyCode){
            case KeyEvent.VK_W -> up = true;
            case KeyEvent.VK_A -> left = true;
            case KeyEvent.VK_D -> right = true;
        }
    }

    @Override
    public void keyReleased(int keyCode){
        switch(keyCode){
            case KeyEvent.VK_W -> up = false;
            case KeyEvent.VK_A -> left = false;
            case KeyEvent.VK_D -> right = false;
        }
    }
}
