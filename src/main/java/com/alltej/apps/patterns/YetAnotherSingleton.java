package com.alltej.apps.patterns;

/**
 * @author Allan Tejano
 * 4/18/2018
 */
public class YetAnotherSingleton {

    private static volatile YetAnotherSingleton instance;

    private YetAnotherSingleton() {
    }

    public static synchronized YetAnotherSingleton getInstance() {
        if (instance == null) {
            instance = new YetAnotherSingleton();
        }
        return instance;
    }
}
