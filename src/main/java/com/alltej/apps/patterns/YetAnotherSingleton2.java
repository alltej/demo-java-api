package com.alltej.apps.patterns;

/**
 * @author Allan Tejano
 * 5/15/2018
 */
public class YetAnotherSingleton2 {

    private YetAnotherSingleton2() {
    }

    private static volatile YetAnotherSingleton2 anInstance;

    public static synchronized YetAnotherSingleton2 getInstance() {
        if (anInstance == null) {
            anInstance = new YetAnotherSingleton2();
        }
        return anInstance;
    }
}
