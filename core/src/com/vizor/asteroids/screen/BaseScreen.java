package com.vizor.asteroids.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.ScreenUtils;

public abstract class BaseScreen implements Screen, InputProcessor {

    private final Stage mainStage;
    private final Stage uiStage;

    public BaseScreen() {
        uiStage = new Stage();
        mainStage = new Stage();

    }

    public Stage getMainStage() {
        return mainStage;
    }

    public Stage getUiStage() {
        return uiStage;
    }

    @Override
    public void render(float dt) {
        mainStage.act(dt);
        uiStage.act(dt);
        update(dt);
        ScreenUtils.clear(0, 0, 0, 1);
        mainStage.draw();
        uiStage.draw();
    }

    public void initialize() {
        mainStage.getActors().clear();
        uiStage.getActors().clear();
    }

    public abstract void update(float dt);

    @Override
    public void resize(int width, int height) {
        stageResize(mainStage, width, height);
        stageResize(uiStage, width, height);
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
        im.addProcessor(uiStage);
        im.addProcessor(mainStage);
    }

    @Override
    public void hide() {
        InputMultiplexer im = (InputMultiplexer) Gdx.input.getInputProcessor();
        im.removeProcessor(this);
        im.removeProcessor(uiStage);
        im.removeProcessor(mainStage);
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
        mainStage.dispose();
        uiStage.dispose();
    }

    private void stageResize(Stage stage, int width, int height) {
        stage.getViewport().update(width, height, true);
        stage.getCamera().viewportWidth = width;
        stage.getCamera().viewportHeight = height;
        stage.getCamera().position
            .set(stage.getCamera().viewportWidth / 2, getMainStage().getCamera().viewportHeight / 2, 0);
        stage.getCamera().update();
    }


}