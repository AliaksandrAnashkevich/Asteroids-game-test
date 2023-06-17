package com.vizor.asteroids.screen;

import com.badlogic.gdx.Gdx;
import com.vizor.asteroids.AsteroidsGame;
import com.vizor.asteroids.actor.BackgroundActor;
import com.vizor.asteroids.actor.TextActor;

public class GameIntroScreen extends BaseScreen {

    private static GameIntroScreen instance;
    private TextActor asteroidsMessage;
    private TextActor pressAnyKeyMessage;

    private GameIntroScreen() {
        super();
    }

    public static GameIntroScreen getInstance() {
        if (instance == null) {
            instance = new GameIntroScreen();
        }
        return instance;
    }

    @Override
    public void initialize() {
        super.initialize();
        asteroidsMessage = new TextActor(getUiStage());
        asteroidsMessage.setText("ASTEROIDS");

        pressAnyKeyMessage = new TextActor(getUiStage());
        pressAnyKeyMessage.setText("PRESS ANY KEY TO START");

        new BackgroundActor(getMainStage());
    }

    @Override
    public void update(float dt) {
        asteroidsMessage.centerAtPosition(Gdx.graphics.getWidth() / 2f,
            Gdx.graphics.getHeight() / 2f);
        pressAnyKeyMessage.centerAtPosition(Gdx.graphics.getWidth() / 2f,
            Gdx.graphics.getHeight() / 10f);
    }

    @Override
    public boolean keyDown(int keycode) {
        AsteroidsGame.getInstance().setGameScreen(GameScreen.getInstance());
        return true;
    }

    @Override
    public void dispose() {
        super.dispose();
    }
}
