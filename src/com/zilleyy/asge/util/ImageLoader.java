package com.zilleyy.asge.util;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

/**
 * Author: Zilleyy
 * <br>
 * Date: 24/04/2021 @ 3:15 pm AEST
 */
public class ImageLoader {

    public static Image loadImage(String path) {
        File file = new File(path);
        Image image = null;
        try {
            image = ImageIO.read(file);
        } catch(IOException exception) {
            // TODO HANDLE EXCEPTION.
            exception.printStackTrace();
        }
        return image;
    }

    public static Image loadImage(int width, int height, String path) {
        return null;
    }

}
