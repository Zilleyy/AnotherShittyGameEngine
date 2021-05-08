package com.zilleyy.asge.gameobject;

import com.zilleyy.asge.Display;
import com.zilleyy.asge.Renderer;
import com.zilleyy.asge.manager.EntityManager;
import com.zilleyy.asge.manager.Manager;
import com.zilleyy.asge.physics.AABB;
import com.zilleyy.asge.util.math.Vector;

import java.awt.*;

import static com.zilleyy.asge.util.logger.Logger.println;

/**
 * Author: Zilleyy
 * <br>
 * Date: 21/04/2021 @ 3:47 pm AEST
 */
public abstract class Entity extends GameObject implements Tickable, Drawable {

    private Sprite sprite;
    private AABB aabb;

    public Entity(Sprite sprite, AABB aabb) {
        super(aabb.getPosition());
        this.sprite = sprite;
        this.aabb = aabb;

        Manager.getInstanceOf(EntityManager.class).add(this);
    }

    public Entity(double x, double y, int width, int height) {
        this(new Sprite(width, height), new AABB(x, y, width, height));
    }

    public Sprite getSprite() {
        return this.sprite;
    }

    /**
     * Getter method for the axis-aligned bounding box.
     * @return the bounding box.
     */
    public AABB getAABB() {
        return this.aabb;
    }

    /**
     * Getter method for the position vector of the entity.
     * @return the position vector.
     */
    public Vector getPosition() {
        return this.aabb.getPosition();
    }

    @Override
    public void draw() {
        // TODO Draw the entity to the Display.
        Renderer.getInstance().drawSprite(this);
    }

    @Override
    public void tick() {
        // TODO Tick the entity.
        this.getAABB().recalculateBoundingBox();
    }

    /**
     * Doesn't work perfectly, but it'll do for not.
     * TODO -Y & +X screen cutoff not perfect.
     * @return
     */
    @Override
    public boolean isOnScreen() {
        return true;
    }

}
