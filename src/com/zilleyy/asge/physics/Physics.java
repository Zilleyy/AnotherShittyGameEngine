package com.zilleyy.asge.physics;

import com.zilleyy.asge.gameobject.Tickable;
import com.zilleyy.asge.manager.TickableManager;
import com.zilleyy.asge.util.math.Vector;

/**
 * Author: Zilleyy
 * <br>
 * Date: 22/04/2021 @ 12:25 pm AEST
 */
public class Physics implements Tickable {

    public Vector position, velocity, acceleration;
    private double friction = 0.90, maxSpeed = 100.0, minSpeed = 0.2;

    public Physics(final Vector position) {
        this.position = position;
        this.velocity = new Vector(0, 0);
        this.acceleration = new Vector(0, 0);

        TickableManager.getInstanceOf(TickableManager.class).add(this);
    }

    public void addForce(final double x, final double y) {
        final double lx = this.velocity.x, ly = this.velocity.y;
        this.velocity.add(x, y);
        this.acceleration.set(this.velocity.x - lx, this.velocity.y - ly);
        this.limit();
    }

    public void addForce(Vector force) {
        this.addForce(force.x, force.y);
    }

    private void limit() {
        this.velocity.x = Math.min(this.velocity.x, this.maxSpeed);
        this.velocity.y = Math.min(this.velocity.y, this.maxSpeed);
        this.velocity.z = Math.min(this.velocity.z, this.maxSpeed);
    }

    @Override
    public void tick() {
        this.velocity.multiply(this.friction);

        if(this.velocity.x < this.minSpeed && this.velocity.x > 0) this.velocity.x = 0;
        if(this.velocity.y < this.minSpeed && this.velocity.y > 0) this.velocity.y = 0;
        if(this.velocity.z < this.minSpeed && this.velocity.z > 0) this.velocity.z = 0;

        if(this.velocity.x > -this.minSpeed && this.velocity.x < 0) this.velocity.x = 0;
        if(this.velocity.y > -this.minSpeed && this.velocity.y < 0) this.velocity.y = 0;
        if(this.velocity.z > -this.minSpeed && this.velocity.z < 0) this.velocity.z = 0;

        this.position.add(this.velocity);
    }

}
