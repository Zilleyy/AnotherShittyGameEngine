package com.zilleyy.asge.util;

import java.lang.reflect.Field;

import static com.zilleyy.asge.util.logger.Logger.println;

/**
 * Author: Zilleyy
 * <br>
 * Date: 23/04/2021 @ 2:52 pm AEST
 */
public class Debugger implements Runnable {

    private Thread thread;
    private Object object;


    public Debugger(Object object) {
        this.object = object;
    }

    @Override
    public void run() {
        while(true) {

            Field[] fields = this.object.getClass().getFields();
            for(int i = 0; i < fields.length; i++) {
                try {
                    Field field = fields[i];
                    println(field.getType().getSimpleName() + " " + field.getName() + " = " + field.get(this.object));
                }
                catch (Exception exception) { exception.printStackTrace(); }
            }

        }
    }

    public synchronized void start() {
        this.thread = new Thread(this);

        println("Starting Debugger for " + this.object.hashCode());
        this.thread.start();
    }

    public synchronized void stop() throws InterruptedException {
        println("Stopping Debugger for " + this.object.hashCode());
        this.thread.join();
    }

}
