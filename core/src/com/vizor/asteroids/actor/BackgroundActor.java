package com.vizor.asteroids.actor;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureWrap;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.vizor.asteroids.resource.ResourceManager;

public class BackgroundActor extends BaseActor {

    private final Texture background;

    public BackgroundActor(Stage s) {
        super(0, 0, s);
        background = new Texture(Gdx.files.internal(ResourceManager.getInstance().getTexturePathBackground()));
        background.setWrap(TextureWrap.Repeat, TextureWrap.Repeat);
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);
        batch.draw(background, 0, 0, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
    }
}
