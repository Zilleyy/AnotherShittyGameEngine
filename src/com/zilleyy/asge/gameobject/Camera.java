package com.zilleyy.asge.gameobject;

import com.zilleyy.asge.input.Input;
import com.zilleyy.asge.physics.Physics;

/**
 * Author: Zilleyy
 * <br>
 * Date: 23/04/2021 @ 2:20 pm AEST
 */
public class Camera extends GameObject implements Tickable {

    private static Camera instance;

    private GameObject following;

    public Camera() {
        super(0, 0);
        Camera.instance = this;
    }

    public static Camera getInstance() {
        return Camera.instance;
    }

    public GameObject getFollowing() {
        return this.following == null ? this : this.following;
    }

    public void follow(GameObject gameObject) {
        this.following = gameObject;
        this.position = gameObject.position;
        this.getPhysics().position = this.position;
    }

    @Override
    public void tick() {
        // key presses.

    }

}
