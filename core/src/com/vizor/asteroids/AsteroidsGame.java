package com.vizor.asteroids;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.vizor.asteroids.screen.BaseScreen;
import com.vizor.asteroids.screen.GameOverScreen;
import com.vizor.asteroids.screen.GameIntroScreen;
import com.vizor.asteroids.screen.GameScreen;

public class AsteroidsGame extends Game {

    private static AsteroidsGame instance;
    private GameScreen gameScreen;
    private GameIntroScreen gameIntroScreen;
    private GameOverScreen gameOverScreen;

    private AsteroidsGame(){
    }

    public static AsteroidsGame getInstance() {
        if (instance == null) {
            instance = new AsteroidsGame();
        }
        return instance;
    }

    public void create() {
        instance = this;

        InputMultiplexer im = new InputMultiplexer();
        Gdx.input.setInputProcessor(im);

        gameScreen = GameScreen.getInstance();
        gameIntroScreen = GameIntroScreen.getInstance();
        gameOverScreen = GameOverScreen.getInstance();
        setGameScreen(gameIntroScreen);
    }

    public void setGameScreen(BaseScreen baseScreen) {
        baseScreen.initialize();
        setScreen(baseScreen);
    }

    @Override
    public void dispose() {
        super.dispose();
        gameIntroScreen.dispose();
        gameScreen.dispose();
        gameOverScreen.dispose();
    }
}