package com.vizor.asteroids.actor;

import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.vizor.asteroids.resource.ResourceManager;

public class LaserActor extends BaseActor
{
    public LaserActor(float x, float y, Stage s)
    {
       super(x,y,s);

       loadTexture(ResourceManager.getInstance().getTexturePathBullet());

       addAction( Actions.delay(1.5f) );
       addAction( Actions.after( Actions.fadeOut(0.5f) ) );
       addAction( Actions.after( Actions.removeActor() ) );

       setSpeed(400);
       setMaxSpeed(400);
       setDeceleration(0);
    }

    public void act(float dt)
    {
        super.act(dt);
        applyPhysics(dt);
        wrapAroundWorld();
    }
}