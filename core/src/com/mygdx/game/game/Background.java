package com.mygdx.game.game;


import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.StarGame;
import com.mygdx.game.screen.GameScreen;

public class Background {
    private final int STAR_COUNT = 1000;
    private GameController gc;
    private StarGame starGame;
    private Texture textureCosmos;
    private Texture textureStar;
    private Background.Star[] stars;

    public Background(GameController gc) {

        this.gc = gc;
        this.textureCosmos = new Texture("bg2.png");
        this.textureStar = new Texture("star16.png");
        this.stars = new Background.Star[1000];

        for(int i = 0; i < this.stars.length; ++i) {
            this.stars[i] = new Background.Star();
        }

    }

    public void render(SpriteBatch batch) {
        batch.draw(this.textureCosmos, 0.0F, 0.0F);

        for(int i = 0; i < this.stars.length; ++i) {
            batch.draw(this.textureStar, this.stars[i].position.x - 8.0F, this.stars[i].position.y - 8.0F, 8.0F, 8.0F, 16.0F, 16.0F, this.stars[i].scale, this.stars[i].scale, 0.0F, 0, 0, 16, 16, false, false);
            if (MathUtils.random(0, 300) < 1) {
                batch.draw(this.textureStar, this.stars[i].position.x - 8.0F, this.stars[i].position.y - 8.0F, 8.0F, 8.0F, 16.0F, 16.0F, this.stars[i].scale * 2.0F, this.stars[i].scale * 2.0F, 0.0F, 0, 0, 16, 16, false, false);
            }
        }

    }

    public void update(float dt) {
        for(int i = 0; i < this.stars.length; ++i) {
            this.stars[i].update(dt);
        }

    }

    private class Star {
        Vector2 position = new Vector2((float)MathUtils.random(-200, 1480), (float)MathUtils.random(-200, 920));
        Vector2 velocity = new Vector2((float)MathUtils.random(-40, -5), 0.0F);
        float scale;

        public Star() {
            this.scale = Math.abs(this.velocity.x) / 40.0F * 0.8F;
        }

        public void update(float dt) {
            Vector2 var10000 = this.position;
            var10000.x += (this.velocity.x - Background.this.gc.getHero().getLastDisplacement().x * 15.0F) * dt;
            var10000 = this.position;
            var10000.y += (this.velocity.y - Background.this.gc.getHero().getLastDisplacement().y * 15.0F) * dt;
            if (this.position.x < -200.0F) {
                this.position.x = 1480.0F;
                this.position.y = (float)MathUtils.random(-200, 920);
            }

        }
    }
}


