package com.alltej.apps.hckrank;

/**
 * @author atejano
 */
 class A {
    public void printName() {
        System.out.println("A");
    }
}

 class B extends A {
    public void printName() {
        System.out.println("B");
    }
}
 class C extends A {
    public void printName() {
        System.out.println("C");
    }
}

public class TowInheritance {
    public static void main(String[] args) {
        B b = new B();
        C c = new C();
//        b = c;

    }
}