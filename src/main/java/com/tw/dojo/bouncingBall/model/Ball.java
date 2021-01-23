package com.tw.dojo.bouncingBall.model;

import java.awt.*;
import java.util.ArrayList;

public class Ball {
    protected static final int DEFAULT_RADIUS = 50;
    protected int x;
    protected int y;
    protected int radius;
    ArrayList<Behavior> behaviours;

    public Ball(int x, int y, int radius, ArrayList<Behavior> behaviours) {
        this.x = x;
        this.y = y;
        this.radius = radius;
        this.behaviours = behaviours;
    }

    protected Ball(int x, int y, ArrayList<Behavior> behaviors) {
        this(x, y, DEFAULT_RADIUS, behaviors);
    }

    // DO NOT CHANGE
    public int radius() {
        return radius;
    }

    // DO NOT CHANGE
    public Point center() {
        return new Point(x, y);
    }

    public void update() {
        for (Behavior behavior : behaviours) {
            behavior.update(this);
        }
    }
}
