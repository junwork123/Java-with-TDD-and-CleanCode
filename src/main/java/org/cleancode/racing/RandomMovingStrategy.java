package org.cleancode.racing;

import java.util.Random;

public class RandomMovingStrategy implements MovingStrategy{
    public static final int THRESHOLD = 4;
    public static final int MAX_BOUND = 10;
    @Override
    public boolean movable() {
        return getRandomNo() >= THRESHOLD;
    }

    private int getRandomNo() {
        return new Random().nextInt(MAX_BOUND);
    }
}
