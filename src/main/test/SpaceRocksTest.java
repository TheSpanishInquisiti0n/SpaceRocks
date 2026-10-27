import java.awt.event.KeyEvent;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

import spacerocks.GameContext;
import spacerocks.GamePanel;
import spacerocks.entities.Asteroid;
import spacerocks.entities.Player;
import spacerocks.states.GameState;
import spacerocks.states.PlayState;
import spacerocks.states.TitleState;

public class SpaceRocksTest {
    private static final String SPRITE = "/sprites/Player.png";

    //fake context for tests to run in a predicatble way
    private static class FakeContext implements GameContext{
        GameState current;
        boolean quit;
        @Override public void setState(GameState next){current = next;}
        @Override public void quit(){quit = true;}
    }

    //tests for collision
    @Test
    void overlappingHitBoxesCollide(){
        Player a = new Player(100, 100, 0, 0, 0, 0, 10, SPRITE);
        Player b = new Player(115, 100, 0, 0, 0, 0, 10, SPRITE);
        assertTrue(a.collidesWith(b));
        assertTrue(b.collidesWith(a));
    }

    //same but opposite
    @Test
    void distantHitBoxesDoNotCollide(){
        Player a = new Player(100, 100, 0, 0, 0, 0, 10, SPRITE);
        Player b = new Player(300, 300, 0, 0, 0, 0, 10, SPRITE);
        assertFalse(a.collidesWith(b));
    }

    //seeing if wrap works the way it's supposed to
    @Test
    void playerWrapsAroundRightEdge(){
        //dx 10 -> 9.9 after friction, 795 + 9.9 = 804.9, wraps to 4.9
        Player p = new Player(GamePanel.WIDTH - 5, 100, 0, 10, 0, 0, 10, SPRITE);
        p.update();
        assertEquals(4.9, p.getX(), 1e-9);
        assertEquals(100, p.getY(), 1e-9);
    }

    //all enemies dont accelerate (yet)
    @Test
    void asteroidMovesAtConstantVelocity(){
        Asteroid a = new Asteroid(new Random(42));
        double startX = a.getX();
        double startY = a.getY();
        a.update();
        a.update();
        double dist = Math.hypot(a.getX() - startX, a.getY() - startY);
        assertEquals(10, dist, 1e-9);
    }

    //just making sure you can actually play the game
    @Test
    void enterOnTitleScreenStartsGame(){
        FakeContext game = new FakeContext();
        new TitleState(game).keyPressed(KeyEvent.VK_ENTER);
        assertInstanceOf(PlayState.class, game.current);
    }
}
