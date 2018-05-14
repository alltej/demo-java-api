package com.alltej.apps.lveperson;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;

/**
 * @author Allan Tejano
 * 5/14/2018
 */
public class BfsPrintByDepth_180514  {
    /* should print below:

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
            ArrayDeque<List<Node>> q = new ArrayDeque<>();
            q.add(  asList( root ) );
            while (!q.isEmpty() ) {
                List<Node> nodes = q.pop();
                System.out.println();
                List<Node> nodesToAdd = new ArrayList<>();
                for ( Node n : nodes ) {
                    System.out.print(n.data);
                    if (n.left != null) {
                        nodesToAdd.add( n.left );
                    }
                    if (n.right != null) {
                        nodesToAdd.add( n.right );
                    }
                }
                if (!nodesToAdd.isEmpty()) {
                    q.add( nodesToAdd );
                }

            }

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

