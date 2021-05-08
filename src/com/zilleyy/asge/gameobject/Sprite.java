package com.zilleyy.asge.gameobject;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Author: Zilleyy
 * <br>
 * Date: 24/04/2021 @ 11:44 am AEST
 */
public class Sprite {

    private Image image;

    public Sprite(Image image) {
        this.image = image;
    }

    public Sprite(int width, int height) {
        this.image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
    }

    public Image getImage() {
        return this.image;
    }

}
