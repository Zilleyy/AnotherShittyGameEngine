package com.zilleyy.asge.util.logger;

/**
 * Author: Zilleyy
 * <br>
 * Date: 23/04/2021 @ 10:17 am AEST
 */
public class Logger {

    public static void print(Object object) {
        System.out.print(object);
    }

    public static void println(Object object) {
        System.out.println(object);
    }

    public static void error(Object object) {
        System.err.println(object);
    }

}
