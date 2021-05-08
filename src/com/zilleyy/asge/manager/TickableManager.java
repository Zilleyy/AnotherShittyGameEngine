package com.zilleyy.asge.manager;

import com.zilleyy.asge.gameobject.Tickable;

/**
 * Author: Zilleyy
 * <br>
 * Date: 22/04/2021 @ 4:24 pm AEST
 */
public class TickableManager extends Manager<Tickable> {

    @Override
    public synchronized void traverse() {
        for(Tickable tickable : this.list) {
            tickable.tick();
        }
        this.list.addAll(this);
        this.clear();
    }

}
