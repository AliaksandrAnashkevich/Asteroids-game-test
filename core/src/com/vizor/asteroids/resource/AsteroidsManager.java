package com.vizor.asteroids.resource;

import java.util.Random;

public enum AsteroidsManager {

    BROWN_BIG("assets/PNG/Meteors/meteorBrown_big4.png", 1),
    BROWN_MED("assets/PNG/Meteors/meteorBrown_med1.png", 5),
    BROWN_SMALL("assets/PNG/Meteors/meteorBrown_small2.png", 10),
    GREY_BIG("assets/PNG/Meteors/meteorGrey_big4.png", 1),
    GREY_MED("assets/PNG/Meteors/meteorGrey_med1.png", 5),
    GREY_SMALL("assets/PNG/Meteors/meteorGrey_small2.png", 10);

    private static final Random randomAsteroids = new Random();
    private final String texturePath;
    private final int score;

    AsteroidsManager(String texturePath, int score) {
        this.texturePath = texturePath;
        this.score = score;
    }

    public static AsteroidsManager getRandom() {
        AsteroidsManager[] asteroidsManager = values();
        return asteroidsManager[randomAsteroids.nextInt(values().length)];
    }

    public String getTexturePath() {
        return texturePath;
    }

    public int getScore() {
        return score;
    }
}
