package com.mygdx.game.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

public class WorldRenderer {
    private GameController gc;
    private SpriteBatch batch;

    public WorldRenderer(GameController gc, SpriteBatch batch) {
        this.gc = gc;
        this.batch = batch;
    }

    public void render() {
        float dt = Gdx.graphics.getDeltaTime();
        ScreenUtils.clear(0.0F, 0.1F, 0.5F, 1.0F);
        this.batch.begin();
        gc.getBackground().render(this.batch);
        gc.getHero().render(this.batch);
        this.batch.end();
    }
}
