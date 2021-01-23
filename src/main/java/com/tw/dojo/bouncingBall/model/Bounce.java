package com.tw.dojo.bouncingBall.model;

import com.tw.dojo.bouncingBall.ui.BallWorld;

public class Bounce implements Behavior {
    public static final int MOVEMENT_SPEED = 12;

    static final int DOWN = 1;
    static final int UP = -1;

    private int direction;

    Bounce(int direction) {
        this.direction = direction;
    }

    @Override
    public void update(Ball ball) {
        direction = reverseDirectionIfNecessary(ball.y, ball.radius);
        ball.y = move(ball.y);
    }

    /***********************************************************************************
     *
     * Do not change Bouncing ALGORITHM below.
     *
     ***********************************************************************************/

    private int reverseDirectionIfNecessary(int y, int radius) {
        if (movingTooHigh(y, radius) || movingTooLow(y, radius)) {
            return switchDirection();
        }

        return this.direction;
    }

    private boolean movingTooLow(int y, int radius) {
        return y + radius >= BallWorld.BOX_HEIGHT && movingDown();
    }

    private boolean movingTooHigh(int y, int radius) {
        return y - radius <= 0 && movingUp();
    }

    private int switchDirection() {
        return movingDown() ? UP : DOWN;
    }

    private int move(int y) {
        return y + (MOVEMENT_SPEED * direction);
    }

    private boolean movingDown() {
        return direction == DOWN;
    }

    private boolean movingUp() {
        return direction == UP;
    }
}
