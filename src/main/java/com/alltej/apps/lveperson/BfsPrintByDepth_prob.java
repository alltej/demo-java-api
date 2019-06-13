package com.alltej.apps.lveperson;

/**
 * @author Allan Tejano
 * 5/2/2018
 */
public class BfsPrintByDepth_prob {
    /*

    Given:
                   A
          B        |          C
     D             |     E          F

    Expected: should print below:

    A
    BC
    DEF

     */
    public static void main( String[] args ) {
        Bst bst = new Bst();
        bst.root = new Node( "A" );
        bst.root.left = new Node( "B" );
        bst.root.right = new Node( "C" );
        bst.root.left.left = new Node( "D" );
        bst.root.right.left = new Node( "E" );
        bst.root.right.right = new Node( "F" );

        bst.printDepth();
    }


    static class Bst {
        Node root;

        public void printDepth() {
            //code here

        }
    }

    static class Node {
        String data;
        Node left, right;

        public Node( String data ) {
            this.data = data;
        }
    }
}


