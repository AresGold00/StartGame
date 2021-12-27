package com.mygdx.game.game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;

public class Hero {
    private Texture texture = new Texture("ship.png");
    private Vector2 position = new Vector2(640.0F, 360.0F);
    private float angle = 0.0F;
    private Vector2 lastDisplacement = new Vector2(0.0F, 0.0F);

    public Vector2 getLastDisplacement() {
        return this.lastDisplacement;
    }

    public Hero() {
    }

    public void render(SpriteBatch batch) {
        batch.draw(this.texture, this.position.x - 32.0F, this.position.y - 32.0F, 32.0F, 32.0F, 64.0F, 64.0F, 1.0F, 1.0F, this.angle, 0, 0, 64, 64, false, false);
    }

    public void update(float dt) {
        if (Gdx.input.isKeyPressed(Input.Keys.A)) {
            this.angle += 180.0F * dt;
        }

        if (Gdx.input.isKeyPressed(Input.Keys.D)) {
            this.angle -= 180.0F * dt;
        }

        if (Gdx.input.isKeyPressed(Input.Keys.W)) {
            Vector2 var10000 = this.position;
            var10000.x += MathUtils.cosDeg(this.angle) * 240.0F * dt;
            var10000 = this.position;
            var10000.y += MathUtils.sinDeg(this.angle) * 240.0F * dt;
            this.lastDisplacement.set(MathUtils.cosDeg(this.angle) * 240.0F * dt, MathUtils.sinDeg(this.angle) * 240.0F * dt);
        } else {
            this.lastDisplacement.set(0.0F, 0.0F);
        }
        if (Gdx.input.isKeyPressed(Input.Keys.S)) {
            Vector2 var10000 = this.position;
            var10000.x -= MathUtils.cosDeg(this.angle) * 140.0F * dt;
            var10000 = this.position;
            var10000.y -= MathUtils.sinDeg(this.angle) * 140.0F * dt;
            this.lastDisplacement.set(MathUtils.cosDeg(this.angle) * 240.0F * dt, MathUtils.sinDeg(this.angle) * 240.0F * dt);
        } else {
            this.lastDisplacement.set(0.0F, 0.0F);
        }

        if (this.position.x < 32.0F) {
            this.position.x = 32.0F;
        }


    }
}

