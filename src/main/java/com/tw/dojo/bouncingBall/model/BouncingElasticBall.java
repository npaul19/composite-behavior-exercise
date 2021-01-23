package com.tw.dojo.bouncingBall.model;

public class BouncingElasticBall extends Ball {

    private final BouncingBall bouncingBall;
    private final ElasticBall elasticBall;

    public BouncingElasticBall(int centerX, int centerY, int bouncingDirection, int elasticDirection) {
        super(centerX, centerY);
        bouncingBall = new BouncingBall(centerX, centerY, bouncingDirection);
        elasticBall = new ElasticBall(centerX, centerY, DEFAULT_RADIUS, elasticDirection);
    }

    @Override
    public void update() {
        bouncingBall.update();
        elasticBall.update();
        y = bouncingBall.y;
        radius = elasticBall.radius();
    }
}
