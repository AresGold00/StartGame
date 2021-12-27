package com.mygdx.game.game;

public class GameController {
    private Background background;
    private Hero hero;

    public Hero getHero() {
        return this.hero;
    }

    public Background getBackground() {
        return background;
    }

    public GameController() {
        this.background = new Background(this);
        this.hero = new Hero();
    }
    public void update(float dt) {
        this.background.update(dt);
        this.hero.update(dt);
    }
}
