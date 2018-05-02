package com.alltej.apps.hdepot;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Allan Tejano
 * 5/2/2018
 */
public class FindLcaApp {


    @Test public void lca_tests( ) {

        Node node = new Node( 20 );
        node.left = new Node( 10 );
        node.right = new Node( 30 );

        //10
        node.left.left = new Node( 6 );
        node.left.right = new Node( 12);

        //6
        node.left.left.left = new Node( 3);

        //30
        node.right.left = new Node( 24 );
        node.right.right = new Node( 34 );

        //24
        node.right.left.left = new Node( 21 );

        //34
        node.right.right.right = new Node( 49 );

        assertEquals( 10, findLca( node, 3, 12 ) );
        assertEquals( 30, findLca( node, 21, 49 ) );
    }

    static class Node {
        int data;
        Node left, right;

        public Node( int data ) {
            this.data = data;
        }
    }

    static  int findLca( final Node node, int a, int b ) {

        Node root = node;
        while ( root != null ) {
            if (root.data > a && root.data > b) {
                root = root.left;
            } else if (root.data < a && root.data < b) {
                root = root.right;
            } else {
                break;
            }

        }
        return root.data;

    }

}
