package com.zilleyy.asge;

import com.zilleyy.asge.input.Input;

import javax.swing.*;
import java.awt.*;

/**
 * Author: Zilleyy
 * <br>
 * Date: 23/04/2021 @ 10:35 am AEST
 */
public class Display extends JFrame {

    private static Display instance;

    public Display(String title, int width, int height) {
        super();

        Display.instance = this;

        setTitle(title);
        setPreferredSize(new Dimension(width + 6, height + 35));

        setResizable(false);

        this.registerListeners();

        add(Renderer.getInstance());
        pack();

        setLocationRelativeTo(null);

        System.out.println(this.getContentPane().getBounds());

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static Display getInstance() {
        return Display.instance;
    }

    private void registerListeners() {
        Renderer.getInstance().addKeyListener(new Input());
    }

}
