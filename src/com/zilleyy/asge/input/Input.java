package com.zilleyy.asge.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import static com.zilleyy.asge.util.logger.Logger.println;

/**
 * Author: Zilleyy
 * <br>
 * Date: 23/04/2021 @ 10:41 am AEST
 */
public class Input implements KeyListener {

    private static Input instance;

    private final boolean[] keys = new boolean[KeyEvent.KEY_LAST];

    public Input() {
        Input.instance = this;
    }

    public static Input getInstance() {
        return Input.instance;
    }

    public static boolean isKeyDown(int keycode) {
        return Input.getInstance().keys[keycode];
    }

    public static boolean isKeyDown(char key) {
        return Input.getInstance().keys[KeyEvent.getExtendedKeyCodeForChar(key)];
    }

    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyPressed(KeyEvent e) {
        this.keys[e.getKeyCode()] = true;
    }

    @Override
    public void keyReleased(KeyEvent e) {
        this.keys[e.getKeyCode()] = false;
    }

}
