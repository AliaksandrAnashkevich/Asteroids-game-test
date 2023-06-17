package com.vizor.asteroids.actor;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.vizor.asteroids.resource.ResourceManager;

public class SpaceshipActor extends BaseActor {

    private int life;

    public SpaceshipActor(int life, Stage s) {
        super(s);
        this.life = life;

        loadTexture(ResourceManager.getInstance().getTexturePathPlayerSpaceship());
        centerAtPosition(Gdx.graphics.getWidth() / 2f, Gdx.graphics.getHeight() / 2f);
        setBoundaryPolygon(8);

        setAcceleration(200);
        setMaxSpeed(100);
        setDeceleration(10);
    }

    public int getLife() {
        return life;
    }

    public void shoot() {
        if (getStage() == null) {
            return;
        }
        LaserActor bulletActor = new LaserActor(0, 0, this.getStage());
        bulletActor.centerAtActor(this);
        bulletActor.setRotation(this.getRotation());
        bulletActor.setMotionAngle(this.getRotation() + 90f);
    }

    public void act(float dt) {
        super.act(dt);
        if (Gdx.input.isKeyPressed(Keys.A)) {
            accelerateAtAngle(getRotation() + 180f);
        }
        if (Gdx.input.isKeyPressed(Keys.D)) {
            accelerateAtAngle(getRotation());
        }
        if (Gdx.input.isKeyPressed(Keys.W)) {
            accelerateAtAngle(getRotation() + 90f);
        }

        float mouseX = Gdx.input.getX();
        float mouseY = Gdx.graphics.getHeight() - Gdx.input.getY();

        float angle = MathUtils.radiansToDegrees * MathUtils
            .atan2(mouseY - getY() - getHeight() / 2, mouseX - getX() - getWidth() / 2);
        setRotation(angle - 90f);
        applyPhysics(dt);

        wrapAroundWorld();
    }

    public void decrementLife() {
        life--;
    }

}