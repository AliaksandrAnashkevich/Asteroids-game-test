package com.vizor.asteroids.resource;

public class ResourceManager {

    private static ResourceManager instance;
    private final String TEXTURE_PATH_SPACESHIP = "assets/PNG/playerShip3_red.png";
    private final String TEXTURE_PATH_BULLET = "assets/PNG/Lasers/laserRed05.png";
    private final String TEXTURE_PATH_BACKGROUND = "assets/Backgrounds/blue.png";

    private ResourceManager() {
    }

    public static ResourceManager getInstance() {
        if (instance == null) {
            instance = new ResourceManager();
        }
        return instance;
    }

    public String getTexturePathPlayerSpaceship() {
        return TEXTURE_PATH_SPACESHIP;
    }

    public String getTexturePathBullet() {
        return TEXTURE_PATH_BULLET;
    }

    public String getTexturePathBackground() {
        return TEXTURE_PATH_BACKGROUND;
    }
}
