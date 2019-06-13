package com.alltej.apps.lveperson;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

import static java.util.Arrays.asList;

/**
 * @author atejano
 */
public class BfsPrintByDepth_soln {
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

            Queue<List<Node>> q = new ArrayDeque<>();
            q.add(asList(root));
            while (!q.isEmpty()) {
                List<Node> nodeList = ((ArrayDeque<List<Node>>) q).pop();
                List<Node> childNodesList = new ArrayList<>();
                for (Node n:nodeList) {
                    System.out.print(n.data);
                    if (n.left!=null) childNodesList.add(n.left);
                    if (n.right!=null) childNodesList.add(n.right);
                }
                System.out.println();
                if (!childNodesList.isEmpty()) q.add(childNodesList);
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


