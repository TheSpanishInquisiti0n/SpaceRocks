package spacerocks.states;

import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import spacerocks.SpaceRocks;
import spacerocks.entities.Asteroid;
import spacerocks.entities.Player;
import spacerocks.entities.Ufo;

//this is the class we might put a builder on if we hate ourselves
public class PlayState implements GameState {
    private final SpaceRocks game;
    private final Player player;
    private final List<Asteroid> asteroids;
    private final List<Ufo> ufos;
    //for keys
    private boolean  up, left, right;

    public PlayState(SpaceRocks game){
        this.game = game;
        player = new Player();
        asteroids = new ArrayList<>();
        ufos = new ArrayList<>();
        asteroids.add(new Asteroid());
        ufos.add(new Ufo());
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
        for(Asteroid asteroid:asteroids){
            asteroid.update();
        }
        for(Ufo ufo:ufos){
            ufo.update();
        }
        player.update();
    }
    
    @Override 
    public void draw(Graphics2D g){
        player.draw(g);
        for(Asteroid asteroid:asteroids){
            asteroid.draw(g);
        }
        for(Ufo ufo:ufos){
            ufo.draw(g);
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
