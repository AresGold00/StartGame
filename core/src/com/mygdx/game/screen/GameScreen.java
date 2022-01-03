package com.mygdx.game.screen;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.game.GameController;
import com.mygdx.game.game.WorldRenderer;
import com.mygdx.game.screen.utils.Assets;

public class GameScreen extends AbstractScreen{
    private GameController gc;
    private WorldRenderer worldRenderer;

    public GameScreen(SpriteBatch batch) {
        super(batch);
    }

    @Override
    public void show() {
        Assets.getInstance().loadAssets(ScreenManager.ScreenType.GAME);
        this.gc = new GameController(batch);
        this.worldRenderer = new WorldRenderer(gc, batch);
    }

    @Override
    public void render(float delta) {
        gc.update(delta);
        worldRenderer.render();
    }

    @Override
    public void dispose() {
        gc.dispose();
    }
}
