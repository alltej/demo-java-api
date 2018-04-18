package com.alltej.apps.patterns;

/**
 * @author Allan Tejano
 * 4/18/2018
 */
public class ThreadSafeSingleton {

    private static volatile ThreadSafeSingleton instance;

    private String message;
    private ThreadSafeSingleton() {
    }

    public synchronized static ThreadSafeSingleton getInstance() {
        if (instance == null) {
            instance = new ThreadSafeSingleton();
        }
        return instance;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage( String message ) {
        this.message = message;
    }
}
