package com.vizor.asteroids.screen;

import com.badlogic.gdx.Gdx;
import com.vizor.asteroids.AsteroidsGame;
import com.vizor.asteroids.actor.BackgroundActor;
import com.vizor.asteroids.actor.TextActor;

public class GameOverScreen extends BaseScreen {

    private TextActor gameOverMessage;
    private TextActor scoreMessage;
    private TextActor pressAnyKeyMessage;

    public GameOverScreen(AsteroidsGame game) {
        super(game);
    }

    @Override
    public void initialize() {
        super.initialize();

        gameOverMessage = new TextActor(getStage());
        gameOverMessage.setText("ASTEROIDS");

        pressAnyKeyMessage = new TextActor(getStage());
        pressAnyKeyMessage.setText("PRESS ANY KEY TO CONTINUE");

        scoreMessage = new TextActor(getStage());
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
        getGame().setGameIntroScreen();
        return true;
    }

    public void setScore(int score){
        scoreMessage.setText("YOUR SCORE: " + score);
    }
}
