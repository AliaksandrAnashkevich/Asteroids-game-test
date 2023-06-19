package com.vizor.asteroids.screen;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.ScreenUtils;
import com.vizor.asteroids.AsteroidsGame;
import com.vizor.asteroids.actor.BackgroundActor;

public abstract class BaseScreen implements Screen, InputProcessor {

    private final AsteroidsGame game;
    private final Stage stage;

    public BaseScreen(AsteroidsGame game) {
        this.game = game;
        stage = new Stage();
    }

    public AsteroidsGame getGame() {
        return game;
    }

    public Stage getStage() {
        return stage;
    }

    @Override
    public void render(float dt) {
        stage.act(dt);
        update(dt);
        ScreenUtils.clear(0, 0, 0, 1);
        stage.draw();
    }

    public void initialize() {
        stage.getActors().clear();

        new BackgroundActor(getStage());
    }

    public abstract void update(float dt);

    @Override
    public void resize(int width, int height) {
        stageResize(stage, width, height);
    }

    @Override
    public void pause() {
    }

    @Override
    public void resume() {
    }

    @Override
    public void show() {
        InputMultiplexer im = (InputMultiplexer) Gdx.input.getInputProcessor();
        im.addProcessor(this);
        im.addProcessor(stage);
    }

    @Override
    public void hide() {
        InputMultiplexer im = (InputMultiplexer) Gdx.input.getInputProcessor();
        im.removeProcessor(this);
        im.removeProcessor(stage);
    }

    @Override
    public boolean keyDown(int keycode) {
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        return false;
    }

    @Override
    public boolean keyTyped(char c) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(float amountX, float amountY) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    public void dispose() {
        stage.dispose();
    }

    private void stageResize(Stage stage, int width, int height) {
        stage.getViewport().update(width, height, true);
        stage.getCamera().viewportWidth = width;
        stage.getCamera().viewportHeight = height;
        stage.getCamera().position
            .set(stage.getCamera().viewportWidth / 2, getStage().getCamera().viewportHeight / 2, 0);
        stage.getCamera().update();
    }
}