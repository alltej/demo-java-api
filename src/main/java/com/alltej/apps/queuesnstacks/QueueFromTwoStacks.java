package com.alltej.apps.queuesnstacks;

import java.util.Stack;

/**
 * @author Allan Tejano
 * 4/14/2018
 */
public class QueueFromTwoStacks {
    public static void main( String[] args ) {
            MyQueue q = new MyQueue();

            q.insert( "A" );
            q.insert( "B" );
            q.insert( "C" );
            q.insert( "D" );
            q.insert( "E" );
        System.out.println(q.dequeu());
        System.out.println(q.dequeu());
        System.out.println(q.dequeu());
    }

    public static class MyQueue {

        Stack<String> s1 = new Stack<>();
        Stack<String> s2 = new Stack<>();

        public void insert( String s ) {
            s1.add( s );
        }

        public String dequeu() {
            if (s2.isEmpty()) {
                while ( !s1.isEmpty() )
                    s2.push( s1.pop() );
            }
            return s2.pop();
        }
    }

}
