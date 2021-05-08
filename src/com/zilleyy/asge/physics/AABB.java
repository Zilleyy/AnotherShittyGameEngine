package com.zilleyy.asge.physics;

import com.zilleyy.asge.gameobject.Camera;
import com.zilleyy.asge.util.math.Vector;

import java.awt.*;

/**
 * This class represents an Axis-Aligned Bounding Box to be used for collision detection.
 */
public class AABB {

    private int width, height;

    private Vector min, max;
    public final Vector position;

    public AABB(double x1, double y1, double x2, double y2) {
        // TODO find which values are actually the min and max.
        this.width = (int) x2;
        this.height = (int)y2;

        this.min = new Vector(Math.min(x1, x2), Math.min(y1, y2));
        this.max = new Vector(x1 + x2, y1 + y2);
        this.position = this.min.midpoint(this.max);
    }

    public Vector getMin() {
        return this.min;
    }

    public void setMin(Vector min) {
        this.min.set(min);
    }

    public Vector getMax() {
        return this.max;
    }

    public void setMax(Vector max) {
        this.max.set(max);
    }

    public int getWidth() {
        return (int) (this.getMax().x - this.getMin().x);
    }

    public int getHeight() {
        return (int) (this.getMax().y - this.getMin().y);
    }

    /**
     * Gets the center of the Axis-Aligned Bounding Box.
     * @return
     */
    public Vector getPosition() {
        return this.position;
    }

    public Vector getTotalMin() {
        Camera camera = Camera.getInstance();
        double ax = this.min.x, ay = this.min.y;
        if(!camera.getFollowing().equals(this)) {
            ax += camera.position.x;
            ay += camera.position.y;
        }
        return new Vector(ax, ay);
    }

    public Vector getTotalMax() {
        Camera camera = Camera.getInstance();
        double ax = this.max.x, ay = this.max.y;
        if(!camera.getFollowing().equals(this)) {
            ax += camera.position.x;
            ay += camera.position.y;
        }
        return new Vector(ax, ay);
    }

    /**
     * Find if two axis-aligned bounding boxes intersect.
     * @param that the other bounding box.
     * @return true if the bounding box intersects
     */
    public boolean intersects(AABB that) {
        return this.min.x < that.min.x + that.max.x &&
               this.min.x + this.max.x > that.min.x &&
               this.min.y < that.min.y + that.max.y &&
               this.min.y + this.max.y > that.min.y;
    }

    public boolean rawIntersectsTotal(AABB that) {
        return this.min.x              <= that.getTotalMin().x + that.getTotalMax().x &&
               this.min.x + this.max.x >= that.getTotalMin().x - that.getWidth()      &&
               this.min.y              <= that.getTotalMin().y + that.getTotalMax().y &&
               this.min.y + this.max.y >= that.getTotalMin().y + that.getHeight();
    }

    public Direction direction(AABB that) {
        return Direction.NONE;
    }

    public void recalculateBoundingBox() {
        this.min.set(this.position.x - this.width / 2.0, this.position.y - this.height / 2.0);
        this.max.set(this.position.x + this.width / 2.0, this.position.y + this.height / 2.0);
    }

}
