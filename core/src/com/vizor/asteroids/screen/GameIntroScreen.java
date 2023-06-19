package com.vizor.asteroids.screen;

import com.badlogic.gdx.Gdx;
import com.vizor.asteroids.AsteroidsGame;
import com.vizor.asteroids.actor.TextActor;

public class GameIntroScreen extends BaseScreen {

    private TextActor asteroidsMessage;
    private TextActor pressAnyKeyMessage;

    public GameIntroScreen(AsteroidsGame game) {
        super(game);
    }

    @Override
    public void initialize() {
        super.initialize();
        asteroidsMessage = new TextActor(getStage());
        asteroidsMessage.setText("ASTEROIDS");

        pressAnyKeyMessage = new TextActor(getStage());
        pressAnyKeyMessage.setText("PRESS ANY KEY TO START");
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
        getGame().setGameScreen();
        return true;
    }

    @Override
    public void dispose() {
        super.dispose();
    }
}
