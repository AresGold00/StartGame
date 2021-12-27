package com.mygdx.game;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.screen.GameScreen;


public class StarGame extends Game {
    private SpriteBatch batch;
    private GameScreen gameScreen;

    public StarGame() {
    }

    public void create() {
        this.batch = new SpriteBatch();
        gameScreen = new GameScreen(batch);
        setScreen(gameScreen);
    }

    public void render() {
        float dt = Gdx.graphics.getDeltaTime();
        getScreen().render(dt);
    }



    public void dispose() {
        this.batch.dispose();
    }


}
