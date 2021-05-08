package com.zilleyy.asge.gameobject;

import com.zilleyy.asge.Display;
import com.zilleyy.asge.Renderer;
import com.zilleyy.asge.input.Input;
import com.zilleyy.asge.manager.DrawableManager;
import com.zilleyy.asge.manager.EntityManager;
import com.zilleyy.asge.manager.Manager;
import com.zilleyy.asge.physics.AABB;
import com.zilleyy.asge.physics.Physics;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static com.zilleyy.asge.util.ImageLoader.loadImage;

/**
 * Author: Zilleyy
 * <br>
 * Date: 23/04/2021 @ 3:47 pm AEST
 */
public class Player extends Entity {

    public Player(double x, double y, int width, int height) {
        super(new Sprite(loadImage("assets/player.png")), new AABB(x, y, width, height));
    }

    @Override
    public void tick() {
        Physics physics = this.getPhysics();
        if(Input.isKeyDown('w')) physics.addForce(0, -0.5);
        if(Input.isKeyDown('a')) physics.addForce(-0.5, 0);
        if(Input.isKeyDown('s')) physics.addForce(0, 0.5);
        if(Input.isKeyDown('d')) physics.addForce(0.5, 0);

        this.getAABB().recalculateBoundingBox();
    }

}
