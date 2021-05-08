package com.zilleyy.asge;

import com.zilleyy.asge.gameobject.Camera;
import com.zilleyy.asge.gameobject.Empty;
import com.zilleyy.asge.gameobject.Entity;
import com.zilleyy.asge.gameobject.Player;
import com.zilleyy.asge.manager.DrawableManager;
import com.zilleyy.asge.manager.EntityManager;
import com.zilleyy.asge.manager.TickableManager;
import com.zilleyy.asge.util.Debugger;

import java.util.Random;

import static com.zilleyy.asge.util.logger.Logger.println;

/**
 * Author: Zilleyy
 * <br>
 * Date: 21/04/2021 @ 3:47 pm AEST
 */
public class Engine {

    private static Engine instance;

    private int fps, tps, frameCount = 0, tickCount = 0;
    private double delta;
    private long last, current, lastSecond;

    boolean needsRendering = false;

    private Engine() {
        Engine.instance = this;
        this.init();
        this.run();
    }

    public static void main(String[] args) {
        new Engine();
    }

    public Engine getInstance() {
        return Engine.instance;
    }

    private void init() {
        new TickableManager();
        new DrawableManager();
        new EntityManager();

        new Renderer();
        new Display("Display", 1280, 720);

        new Player(0, 0, 200, 200);
    }

    private void run() {
        boolean running = true;
        this.last = System.nanoTime();
        this.lastSecond = this.last + 1_000_000_000;
        while (running) {
            this.current = System.nanoTime();
            this.delta += (this.current - this.last) / (1_000_000_000.0 / 60.0);

            while (this.delta >= 1) {
                this.tickCount++;
                this.delta--;
                this.needsRendering = true;
                this.tick();
            }

            if (needsRendering) {
                this.frameCount++;
                this.needsRendering = false;
                this.draw();
            }

            if (last >= this.lastSecond) {
                this.fps = this.frameCount;
                this.tps = this.tickCount;
                this.frameCount = 0;
                this.tickCount = 0;
                this.lastSecond = System.nanoTime() + 1_000_000_000;

                Display.getInstance().setTitle("FPS: " + this.fps + " TPS: " + this.tps);
            }
            this.last = this.current;
        }
    }

    private void tick() {
        TickableManager.getInstanceOf(TickableManager.class).traverse();
    }

    private void draw() {
        Renderer.getInstance().prepare();

        Renderer.getInstance().drawBackground();
        DrawableManager.getInstanceOf(DrawableManager.class).traverse();

        Renderer.getInstance().cleanup();
    }

}
