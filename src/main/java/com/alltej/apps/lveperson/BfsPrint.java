package com.alltej.apps.lveperson;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

import static java.util.Arrays.asList;

/**
 * @author Allan Tejano
 * 4/30/2018
 */
public class BfsPrint {

    public  static class Node {
        String data;
        Node left;
        Node right;

        public Node( String data ) {
            this.data = data;
        }

        public static Node of( String data ) {
            return new Node( data );
        }
    }

    private Node a;

    @BeforeEach
    @Test public void setup() {
         a = Node.of( "A" );
        Node b = Node.of( "B" );
        Node c = Node.of( "C" );
        Node d = Node.of( "D" );
        Node e = Node.of( "E" );
        Node f = Node.of( "F" );
        Node g = Node.of( "G" );

        a.left = b;
        a.right = c;
        b.left = d;
        c.left = e;
        c.right = f;
        d.left = g;
    }


    @Test public void bfs_print() {
        //output:
        //A
        //BC
        //DEF
        //G

        printBFS( a );
    }

    public static void printBFS(Node a){
        ArrayDeque<List<Node>> queue = new ArrayDeque<>();
        queue.push( asList(a) );
        while(!queue.isEmpty()){
            List<Node> t = queue.pop();
            List<Node> list = new ArrayList<>();
            for ( Node n : t ) {
                if(n.left!=null){
                    list.add( n.left);
                }
                if(n.right!=null){
                    list.add( n.right);
                }
            }
            if (!list.isEmpty()) {
                queue.push( list );
            }
            System.out.println();
            for ( Node elment : t ) {
                System.out.print(elment.data);
            }
        }
    }
}
