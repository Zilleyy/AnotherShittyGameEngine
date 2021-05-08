package com.zilleyy.asge.physics;

/**
 * Author: Zilleyy
 * <br>
 * Date: 23/04/2021 @ 9:46 am AEST
 */
public enum Direction {

    UP(true),
    DOWN(true),
    LEFT(true),
    RIGHT(true),
    NONE(false);

    private boolean intersecting;

    Direction(boolean intersecting) {
        this.intersecting = intersecting;
    }

    boolean isIntersecting() {
        return this.intersecting;
    }

}
