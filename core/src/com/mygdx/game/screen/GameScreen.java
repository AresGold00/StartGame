package com.mygdx.game.screen;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.game.GameController;
import com.mygdx.game.game.WorldRenderer;

public class GameScreen extends AbstractScreen{
    private SpriteBatch batch;
    private GameController gc;
    private WorldRenderer worldRenderer;
    public  GameScreen(SpriteBatch batch){
        this.batch=batch;

    }

    @Override
    public void show() {
        this.gc = new GameController();
        this.worldRenderer = new WorldRenderer(gc,batch);
    }

    @Override
    public void render(float delta) {
        gc.update(delta);
        worldRenderer.render();
    }
}