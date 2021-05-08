package com.zilleyy.asge.manager;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Author: Zilleyy
 * <br>
 * Date: 22/04/2021 @ 4:25 pm AEST
 */
public abstract class Manager<E> extends ArrayList<E> {

    private static List<Manager> instances = new ArrayList<>();
    public List<E> list = new ArrayList<>();

    public Manager() {
        super();
        Manager.instances.add(this);
    }

    /**
     * Static instance getter for the Manager class or subclass.
     * @return the instance of the Manager class.
     */
    public static Manager getInstanceOf(Class<? extends Manager> clazz) {
        for(Manager manager : Manager.instances) {
            if(manager.getClass().getName().equals(clazz.getName())) return manager;
        }
        return null;
    }

    /**
     * This method searches the list to see if any of the objects contain the inputted object.
     * @param object the object to search for.
     * @return the matching object or null.
     */
    // TODO Add "NoReflection" to find the source of the object.
    //public abstract Type search(Object object);

    /**
     * This abstract method represents a method that will traverse the array of objects<br>
     * to carry out some form of operation, e.g. Ticking every object or drawing every object.
     */
    public abstract void traverse();

}
