package com.zilleyy.asge.gameobject;

import com.zilleyy.asge.Display;
import com.zilleyy.asge.manager.DrawableManager;
import com.zilleyy.asge.manager.TickableManager;
import com.zilleyy.asge.physics.Physics;
import com.zilleyy.asge.util.math.Vector;

import java.util.ArrayList;

/**
 * Author: Zilleyy
 * <br>
 * Date: 22/04/2021 @ 12:31 pm AEST
 */
public abstract class GameObject {

    public Vector position;
    private final Physics physics;

    public GameObject(final Vector position) {
        this.position = position;
        this.physics = new Physics(this.position);

        if(this instanceof Tickable) TickableManager.getInstanceOf(TickableManager.class).add(this);
        if(this instanceof Drawable) DrawableManager.getInstanceOf(DrawableManager.class).add(this);
    }

    /**
     * @param x the starting x position of the GameObject.
     * @param y the starting y position of the GameObject.
     */
    public GameObject(double x, double y) {
        this(new Vector(x, y));
    }

    /**
     * Getter method for the physics of the GameObject.
     * @return the Physics object.
     */
    public Physics getPhysics() {
        return this.physics;
    }

    public boolean isOnScreen() {
        return true;
        //Camera camera = Camera.getInstance();
        //Display display = Display.getInstance();
        //return !(this.position.x + camera.position.x > display.getSize().getWidth() || this.position.x + camera.position.x < 0 || this.position.y + camera.position.y > display.getSize().getHeight() || this.position.y + camera.position.y < 0);
    }

}
