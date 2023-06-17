package com.vizor.asteroids.screen;

import com.badlogic.gdx.Gdx;
import com.vizor.asteroids.AsteroidsGame;
import com.vizor.asteroids.actor.BackgroundActor;
import com.vizor.asteroids.actor.TextActor;

public class GameOverScreen extends BaseScreen {

    private static GameOverScreen instance;
    private TextActor gameOverMessage;
    private TextActor scoreMessage;
    private TextActor pressAnyKeyMessage;

    private GameOverScreen() {
        super();
    }

    public static GameOverScreen getInstance() {
        if (instance == null) {
            instance = new GameOverScreen();
        }
        return instance;
    }

    @Override
    public void initialize() {
        super.initialize();
        gameOverMessage = new TextActor(getUiStage());
        gameOverMessage.setText("ASTEROIDS");

        pressAnyKeyMessage = new TextActor(getUiStage());
        pressAnyKeyMessage.setText("PRESS ANY KEY TO START");

        scoreMessage = new TextActor(getUiStage());

        new BackgroundActor(getMainStage());
    }

    @Override
    public void update(float dt) {
        gameOverMessage.centerAtPosition(Gdx.graphics.getWidth() / 2f,
            Gdx.graphics.getHeight() / 2f);
        pressAnyKeyMessage.centerAtPosition(Gdx.graphics.getWidth() / 2f,
            Gdx.graphics.getHeight() / 10f);

        scoreMessage.centerAtPosition(Gdx.graphics.getWidth() / 2f,
            Gdx.graphics.getHeight() / 5f);
    }

    @Override
    public boolean keyDown(int keycode) {
        AsteroidsGame.getInstance().setGameScreen(GameIntroScreen.getInstance());
        return true;
    }

    public void setScore(int score){
        scoreMessage.setText("YOUR SCORE: " + score);
    }
}
