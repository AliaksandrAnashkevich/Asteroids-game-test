package com.vizor.asteroids.actor;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator.FreeTypeFontParameter;
import com.badlogic.gdx.scenes.scene2d.Stage;

public class TextActor extends BaseActor {

    private String text;
    private BitmapFont font;

    public TextActor(Stage s) {
        super(s);
        FreeTypeFontGenerator generator = new FreeTypeFontGenerator(
            Gdx.files.internal("assets/Bonus/kenvector_future.ttf"));
        FreeTypeFontParameter parameter = new FreeTypeFontParameter();
        font = generator.generateFont(parameter);
        generator.dispose();
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public void centerAtPosition(float x, float y) {
        GlyphLayout layout = new GlyphLayout();
        layout.setText(font, text);
        float width = layout.width;
        float height = layout.height;
        setPosition(x - width / 2, y - height / 2);
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);

        font.setColor(Color.WHITE);
        font.draw(batch, text, getX(), getY());
    }
}
