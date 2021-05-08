package com.zilleyy.asge;

import com.zilleyy.asge.gameobject.Camera;
import com.zilleyy.asge.gameobject.Entity;
import com.zilleyy.asge.gameobject.Sprite;
import com.zilleyy.asge.manager.DrawableManager;
import com.zilleyy.asge.physics.AABB;
import com.zilleyy.asge.util.math.Vector;

import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.util.Random;

import static com.zilleyy.asge.util.ImageLoader.loadImage;

/**
 * Author: Zilleyy
 * <br>
 * Date: 23/04/2021 @ 10:45 am AEST
 */
public class Renderer extends Canvas {

    private static Renderer instance;

    private Graphics graphics;
    private Image background = loadImage("assets/stars_bg.png");

    public Renderer() {
        Renderer.instance = this;
    }

    public static Renderer getInstance() {
        return Renderer.instance;
    }

    /**
     * Must prepare the renderer for every frame.
     */
    public void prepare() {
        BufferStrategy bufferStrategy = getBufferStrategy();
        if(bufferStrategy == null) {
            createBufferStrategy(2);
            bufferStrategy = getBufferStrategy();
        }

        this.graphics = bufferStrategy.getDrawGraphics();
        this.graphics.clearRect(0, 0, Display.getInstance().getWidth(), Display.getInstance().getHeight());
    }

    /**
     * Cleanup all the graphics objects, ready for the next frame.
     */
    public void cleanup() {
        this.graphics.dispose();
        getBufferStrategy().show();
    }

    public void box(AABB aabb) {
        double x = aabb.getMin().x;
        double y = aabb.getMin().y;
        int w = aabb.getWidth();
        int h = aabb.getHeight();

        this.graphics.fillRect((int) x, (int) y, w, h);
    }

    public void drawSprite(Entity entity) {
        Sprite sprite = entity.getSprite();
        this.graphics.drawImage(sprite.getImage(), (int) entity.getPosition().x - entity.getAABB().getWidth() / 2, (int) entity.getPosition().y - entity.getAABB().getHeight() / 2, this);
    }

    public void drawBackground() {
        this.graphics.drawImage(this.background, 0, 0, this);
    }

}
