package spacerocks;

import spacerocks.states.GameState;

public interface GameContext{
    public void setState(GameState next);

    public void quit();
}

//for the context class for updating gamestates through spacrocks
//spacerocks will implement this, done now
