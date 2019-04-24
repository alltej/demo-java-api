package com.alltej.apps.hdepot;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FindLcaApp_Template {

    @Test
    public void lca_tests( ) {

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

        //Node class here
    class Node {
            //write code here

            public Node right;public Node left;
            private int value;
            public Node(int value) {
                this.value = value;
            }
        }

    static  int findLca( final Node node, int a, int b ) {
        //write code here
        Node currentNode = node;
        while (currentNode != null) {
            if (currentNode.value > a && currentNode.value > b) {
                currentNode = currentNode.left;
            } else if (currentNode.value < a && currentNode.value < b) {
                currentNode = currentNode.right;
            } else {
                break;
            }
        }
        return currentNode.value;
    }
}
