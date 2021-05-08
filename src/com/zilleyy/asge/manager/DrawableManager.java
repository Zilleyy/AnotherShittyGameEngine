package com.zilleyy.asge.manager;

import com.zilleyy.asge.Renderer;
import com.zilleyy.asge.gameobject.Drawable;
import com.zilleyy.asge.gameobject.GameObject;

import static com.zilleyy.asge.util.logger.Logger.println;

/**
 * Author: Zilleyy
 * <br>
 * Date: 22/04/2021 @ 4:25 pm AEST
 */
public class DrawableManager extends Manager<Drawable> {

    public static GameObject current;

    @Override
    public void traverse() {
        for(Drawable drawable : this.list) {
            if(drawable instanceof GameObject && ((GameObject) drawable).isOnScreen()) {
                DrawableManager.current = (GameObject) drawable;
                drawable.draw();
            } else if(!(drawable instanceof GameObject)) drawable.draw();
        }
        this.list.addAll(this);
        this.clear();
    }

}
