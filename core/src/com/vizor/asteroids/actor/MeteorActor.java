package com.vizor.asteroids.actor;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.vizor.asteroids.resource.AsteroidsManager;

public class MeteorActor extends BaseActor {

    private int score;

    public MeteorActor(Stage s) {
        super(s);
        randomPosition();

        AsteroidsManager asteroidsManager = AsteroidsManager.getRandom();
        loadTexture(asteroidsManager.getTexturePath());
        this.score = asteroidsManager.getScore();

        float random = MathUtils.random(30);

        addAction(Actions.forever(Actions.rotateBy(30 + random, 1)));

        setSpeed(50 + random);
        setMaxSpeed(50 + random);
        setDeceleration(0);

        setMotionAngle(MathUtils.random(360));
    }

    public int getScore() {
        return score;
    }

    public void randomPosition() {
        float regulation = MathUtils.random(10);

        float positionX = MathUtils.random(regulation, Gdx.graphics.getWidth() - regulation);
        float positionY = MathUtils.random(regulation, Gdx.graphics.getHeight() - regulation);
        centerAtPosition(positionX, positionY);
    }

    public void act(float dt) {
        super.act(dt);
        applyPhysics(dt);
        wrapAroundWorld();
    }
}