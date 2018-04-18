package com.alltej.apps.patterns;

/**
 * @author Allan Tejano
 * 4/18/2018
 */
public class SingletonAppExample {
    public static void main(String[] args) {
        ThreadSafeSingleton instance = ThreadSafeSingleton.getInstance();
        instance.setMessage( "hello" );

        System.out.println(instance.getMessage());
        SomeClass sc = new SomeClass( "world" );

        System.out.println("printing output 1");
        sc.print();

        System.out.println("printing output 2");
        SomeClass2 sc2 = new SomeClass2();
        sc2.print2();
    }
}

class SomeClass {

    private String message;

    ThreadSafeSingleton tsf = ThreadSafeSingleton.getInstance();

    public SomeClass( String message ) {
        this.message = message;
        System.out.println(tsf.getMessage());
        tsf.setMessage( message );
    }

    public void print() {
        System.out.println(tsf.getMessage());
    }
}

class SomeClass2 {
    public void print2() {
        System.out.println(ThreadSafeSingleton.getInstance().getMessage());;
    }
}
