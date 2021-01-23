package com.tw.dojo.bouncingBall.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class BallFactory {

    public static Ball[] all() {
        return new Ball[]{
                bouncingBall(75, 50, Bounce.DOWN),
                elasticBall(250, 100, Ball.DEFAULT_RADIUS, Elastic.SHRINK),
                bouncingElasticBall(400, 150, Bounce.DOWN, Elastic.SHRINK)
        };
    }

    public static Ball bouncingBall(int centerX, int centerY, int direction) {
        Behavior bounce = new Bounce(direction);
        return new Ball(centerX, centerY, new ArrayList<>(
                Collections.singletonList(bounce)
        ));
    }

    public static Ball elasticBall(int centerX, int centerY, int radius, int direction) {
        Behavior elastic = new Elastic(direction);
        return new Ball(centerX, centerY, radius, new ArrayList<>(
                Collections.singletonList(elastic)
        ));
    }

    public static Ball bouncingElasticBall(int centerX, int centerY, int bouncingDirection, int elasticDirection) {
        Behavior bounce = new Bounce(bouncingDirection);
        Behavior elastic = new Elastic(elasticDirection);
        return new Ball(centerX, centerY, new ArrayList<>(
                Arrays.asList(bounce, elastic)
        ));
    }
}
