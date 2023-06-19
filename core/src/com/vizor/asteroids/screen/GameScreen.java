package com.vizor.asteroids.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.vizor.asteroids.AsteroidsGame;
import com.vizor.asteroids.actor.BackgroundActor;
import com.vizor.asteroids.actor.BaseActor;
import com.vizor.asteroids.actor.LaserActor;
import com.vizor.asteroids.actor.MeteorActor;
import com.vizor.asteroids.actor.SpaceshipActor;
import com.vizor.asteroids.actor.TextActor;

public class GameScreen extends BaseScreen {

    private SpaceshipActor spaceship;
    private TextActor messages;
    private int score;

    public GameScreen(AsteroidsGame game) {
        super(game);
    }

    @Override
    public void initialize() {
        super.initialize();

        score = 0;

        spaceship = new SpaceshipActor(3, getStage());
        messages = new TextActor(getStage());
        messages.setText("SCORE: " + score + "\n LIFE: " + spaceship.getLife());

        for (int i = 0; i < 5; i++) {
            new MeteorActor(getStage());
        }
    }

    @Override
    public void update(float dt) {
        messages.setPosition(10, Gdx.graphics.getHeight() - 10);

        for (BaseActor meteorActor : BaseActor.getList(getStage(), MeteorActor.class.getName())) {
            if (meteorActor.overlaps(spaceship)) {
                if (spaceship.getLife() <= 1) {
                    spaceship.remove();
                    getGame().setGameOverScreen(score);
                } else {
                    spaceship.decrementLife();
                    messages.setText("SCORE: " + score + "\n LIFE: " + spaceship.getLife());
                    meteorActor.remove();
                    new MeteorActor(getStage());
                }
            }
            for (BaseActor laserActor : BaseActor.getList(getStage(), LaserActor.class.getName())) {
                if (laserActor.overlaps(meteorActor)) {
                    score += ((MeteorActor) meteorActor).getScore();
                    messages.setText("SCORE: " + score + "\n LIFE: " + spaceship.getLife());
                    laserActor.remove();
                    meteorActor.remove();
                    new MeteorActor(getStage());
                }
            }
        }
    }

    @Override
    public boolean keyDown(int keycode) {
        if (keycode == Keys.SPACE) {
            spaceship.shoot();
        }

        return false;
    }

    @Override
    public void dispose() {
        super.dispose();
    }
}

