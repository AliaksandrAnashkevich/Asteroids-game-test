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

    private static GameScreen instance;
    private SpaceshipActor spaceship;
    private TextActor messages;
    private int score;

    private GameScreen() {
        super();
        initialize();
    }

    public static GameScreen getInstance() {
        if (instance == null) {
            instance = new GameScreen();
        }
        return instance;
    }

    @Override
    public void initialize() {
        super.initialize();

        score = 0;
        new BackgroundActor(getMainStage());

        spaceship = new SpaceshipActor(3, getMainStage());
        messages = new TextActor(getUiStage());
        messages.setText("SCORE: " + score + "\n LIFE: " + spaceship.getLife());

        for (int i = 0; i < 5; i++) {
            new MeteorActor(getMainStage());
        }
    }

    public void update(float dt) {
        messages.setPosition(10, Gdx.graphics.getHeight() - 10);

        for (BaseActor meteorActor : BaseActor.getList(getMainStage(), MeteorActor.class.getName())) {
            if (meteorActor.overlaps(spaceship)) {
                if (spaceship.getLife() <= 1) {
                    spaceship.remove();
                    AsteroidsGame.getInstance().setGameScreen(GameOverScreen.getInstance());
                    GameOverScreen.getInstance().setScore(score);
                } else {
                    spaceship.decrementLife();
                    messages.setText("SCORE: " + score + "\n LIFE: " + spaceship.getLife());
                    meteorActor.remove();
                    new MeteorActor(getMainStage());
                }
            }
            for (BaseActor laserActor : BaseActor.getList(getMainStage(), LaserActor.class.getName())) {
                if (laserActor.overlaps(meteorActor)) {
                    score += ((MeteorActor) meteorActor).getScore();
                    messages.setText("SCORE: " + score + "\n LIFE: " + spaceship.getLife());
                    laserActor.remove();
                    meteorActor.remove();
                    new MeteorActor(getMainStage());
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

