package com.alltej.apps.hdepot;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Allan Tejano
 * 5/2/2018
 */
public class FindLcaApp_soln {
    /***
     * Find the least common ancestor(LCA) of two nodes in BST
     *                  20
     *        10        |          30
     *    6        12   |     24            34
     * 3                | 21                     49
     *
     *   lca(3,12)=10
     *   lca(21,49)=20
     *
     */
    private Node root;

    @BeforeEach
    public void setup() {
        root = new Node( 20 );
        root.left = new Node( 10 );
        root.right = new Node( 30 );

        //10
        root.left.left = new Node( 6 );
        root.left.right = new Node( 12);

        //6
        root.left.left.left = new Node( 3);

        //30
        root.right.left = new Node( 24 );
        root.right.right = new Node( 34 );

        //24
        root.right.left.left = new Node( 21 );

        //34
        root.right.right.right = new Node( 49 );

    }

    @Test public void printPreOrderTraversal() {
        printPreOrderTraversal( root );
    }

    @Test public void lca_tests( ) {
        assertEquals( 10, findLca( root, 3, 12 ) );
        assertEquals( 30, findLca( root, 21, 49 ) );
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

    static void printPreOrderTraversal(Node node) {
        if (node != null) {
            System.out.print(node.data + ", ") ;
            printPreOrderTraversal( node.left );
            printPreOrderTraversal( node.right );
        }


    }

}
