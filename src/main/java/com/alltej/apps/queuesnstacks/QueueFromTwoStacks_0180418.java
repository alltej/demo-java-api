package com.alltej.apps.queuesnstacks;

import java.util.Stack;

/**
 * @author Allan Tejano
 * 4/18/2018
 */
public class QueueFromTwoStacks_0180418 {

    private Stack<String> s1;

    private Stack<String> s2;

    public QueueFromTwoStacks_0180418() {
        s1 = new Stack<>();
        s2 = new Stack<>();
    }

    public void push( String s ) {
        s1.push( s );
    }
    public String pop( ) {
        if (s1.isEmpty() && s2.isEmpty()) return null;
        if (s2.isEmpty()) {
            while ( !s1.isEmpty() ) {
                s2.push( s1.pop() );
            }
        }
        return s2.pop();
    }

    public static void main( String[] args ) {
        QueueFromTwoStacks_0180418 q = new QueueFromTwoStacks_0180418();
        q.push( "A" );
        q.push( "B" );
        q.push( "C" );
        q.push( "D" );
        System.out.println(q.pop());;
        System.out.println(q.pop());;
        q.push( "E" );
        q.push( "F" );
        System.out.println(q.pop());;
    }
}

