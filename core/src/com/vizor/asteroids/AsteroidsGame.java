package com.vizor.asteroids;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.vizor.asteroids.screen.GameIntroScreen;
import com.vizor.asteroids.screen.GameOverScreen;
import com.vizor.asteroids.screen.GameScreen;

public class AsteroidsGame extends Game {

    private GameScreen gameScreen;
    private GameIntroScreen gameIntroScreen;
    private GameOverScreen gameOverScreen;

    @Override
    public void create() {
        InputMultiplexer im = new InputMultiplexer();
        Gdx.input.setInputProcessor(im);

        gameScreen = new GameScreen(this);
        gameIntroScreen = new GameIntroScreen(this);
        gameOverScreen = new GameOverScreen(this);
        setGameIntroScreen();
    }

    public void setGameIntroScreen() {
        gameIntroScreen.initialize();
        setScreen(gameIntroScreen);
    }

    public void setGameScreen() {
        gameScreen.initialize();
        setScreen(gameScreen);
    }

    public void setGameOverScreen(int score) {
        gameOverScreen.initialize();
        gameOverScreen.setScore(score);
        setScreen(gameOverScreen);
    }

    @Override
    public void dispose() {
        super.dispose();
        gameIntroScreen.dispose();
        gameScreen.dispose();
        gameOverScreen.dispose();
    }
}