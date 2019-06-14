package com.alltej.apps.queuesnstacks;

import org.junit.jupiter.api.Test;

import java.util.Stack;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Allan Tejano
 * 4/18/2018
 */
public class QueueFromTwoStacks_soln {
    @Test
    public void myqueue_test( ) {
        MyQueue q = new MyQueue();
        q.push( "A" );
        q.push( "B" );
        q.push( "C" );
        q.push( "D" );
        assertEquals("A",(q.pop()));
        assertEquals("B",(q.pop()));
        q.push( "E" );
        q.push( "F" );
        assertEquals("C",(q.pop()));
    }

    private static class MyQueue {

        private Stack<String> s1;

        private Stack<String> s2;

        public MyQueue() {
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
    }
}

