package com.alltej.apps;

import java.util.Collection;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author atejano
 */
public class IntellijShortCutPractice {

    public static void main(String[] args) {
//*        Move cursor between camelhumps or word
        PoorlyNamedClass pnc = new PoorlyNamedClass("hello world");

//*        Move cursor to begin or end of line
        String s = "The quick brown fox jump over the lazy dog";

//*        Move cursor to begin or end of file

//*        Move line up or down.
        System.out.println(s);

//*        Move statement up or down (move code block). Cursor in begin of block
//        move this two blocks of code up/down
        for (int i = 0; i < 10; i++) {
            System.out.println(i);
        }

        for (int x = 0; x < 5; x++) {
            System.out.println(x);
        }


//*        Duplicate Line. Create another variable and name it "city";
//*        Use forward delete to delete old variable "zip".
//*        Practice the backward delete
//        Output will look like this:

//        String city = "Atlanta";
//        String zip = "Atlanta";

        String city = "Atlanta";

//*        Delete Line. Delete the new line above created via duplicate line method.

    }

    public void someMethod() {
        //*View parameter info
        //Create new ThreadPoolExecutor() and view the parameter info
        //ExecutorService es = new ThreadPoolExecutor();
        ExecutorService executor = new ThreadPoolExecutor(3, 5, 1000,);
    }

    //Comment/uncomment this block of code
    //Comment/uncomment block can be done in two ways:
    //*1. using the "//" for each line
    //*2. using /* ...*/
    public void commentBlockOfCode() {
        System.out.println("this is great");
    }

    //*Collapse/expand this this method
    public void longMethodToCollapes() {
        for (int i = 0; i < 5; i++) {
            System.out.println("x");
        }

        for (int i = 0; i < 7; i++) {
            System.out.println("y");
        }

        for (int i = 0; i < 9; i++) {
            System.out.println("z");
        }
    }

    //* Navigate to a class by using the shortcut and
    //*  1. search by partial match
    //*  2. camel humps
    //*  3. wildcard search

    //* Navigate back to code
    //* Navigate forward to code

    //*Navigate to file

    //*Navigate to symbol

    //*Navigate to action


    //*Open recent files

    //*Open recently edited files

    //*select one word at a time

    String sentence = "The qucik brown fox jump over the lazy dog";

    void postFixSuggest(Collection<String> s) {
        //* view postfix suggestions for s and generate an if s not null check
        if (s != null) {

        }
    }

}


class PoorlyNamedClass {
    private String name;

    PoorlyNamedClass(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}


//*Generate constructor, getter, setter, equals/hash on Person class below
class Person {
    private String name;
    private int age;
}

class BadlyFormattedFile {
    private String s;

    public BadlyFormattedFile() {
    }

    void someMethod() {
        for (int i = 0; i < 5; i++) {
            System.out.println("s");
        }
    }
}