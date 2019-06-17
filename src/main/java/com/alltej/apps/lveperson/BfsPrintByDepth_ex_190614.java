package com.alltej.apps.lveperson;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

import static java.util.Arrays.asList;

/**
 * @author atejano
 */
public class BfsPrintByDepth_ex_190614 {
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
                List<Node> pop = ((ArrayDeque<List<Node>>) q).pop();
                List<Node> childNodes = new ArrayList<>();
                for (Node n:pop) {
                    System.out.print(n.name);
                    if (n.left !=null) childNodes.add(n.left);
                    if (n.right !=null) childNodes.add(n.right);
                }
                if (!childNodes.isEmpty()) q.add(childNodes);
                System.out.println();
            }
        }
    }


    static class Node {
        public String name;
        public Node left, right;
        public Node(String name) {

            this.name = name;
        }
    }


}


