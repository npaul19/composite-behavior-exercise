package com.tw.dojo.bouncingBall.model;

public class Elastic implements Behavior {
    public static final int GROWTH_RATE = 2;

    static final int GROW = 1;
    static final int SHRINK = -1;

    private int growthDirection;

    Elastic(int growthDirection) {
        this.growthDirection = growthDirection;
    }

    @Override
    public void update(Ball ball) {
        growthDirection = reverseGrowthDirectionIfNecessary(ball.radius);
        ball.radius = next(ball.radius);
    }

    /***********************************************************************************
     *
     * Do not change Elastic ALGORITHM below.
     *
     **********************************************************************************
     * @param radius of Ball*/

    private int reverseGrowthDirectionIfNecessary(int radius) {
        if (growingTooBig(radius) || shrinkingTooSmall(radius)) {
            return switchDirection();
        }

        return this.growthDirection;
    }

    private boolean shrinkingTooSmall(int radius) {
        return radius <= 0 && shrinking();
    }

    private boolean growingTooBig(int radius) {
        return radius >= Ball.DEFAULT_RADIUS && growing();
    }

    private int switchDirection() {
        return growing() ? SHRINK : GROW;
    }

    private int next(int radius) {
        return radius + (GROWTH_RATE * growthDirection);
    }

    private boolean shrinking() {
        return growthDirection == SHRINK;
    }

    private boolean growing() {
        return growthDirection == GROW;
    }
}
