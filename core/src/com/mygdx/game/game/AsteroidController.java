package com.mygdx.game.game;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.mygdx.game.game.helpers.ObjectPool;
import com.mygdx.game.screen.utils.Assets;

public class AsteroidController extends ObjectPool<Asteroid> {
    private GameController gc;

    @Override
    protected Asteroid newObject() {
        return new Asteroid(gc);
    }

    public AsteroidController(GameController gc) {
        this.gc = gc;
    }

    public void render(SpriteBatch batch) {
        for (int i = 0; i < activeList.size(); i++) {
            Asteroid a = activeList.get(i);
            a.render(batch);
        }
    }

    public void setup(float x, float y, float vx, float vy, float scale){
        getActiveElement().activate(x, y, vx, vy, scale);
    }

    public void update(float dt){
        for (int i = 0; i < activeList.size(); i++) {
            activeList.get(i).update(dt);
        }
        checkPool();
    }
}
