package com.alltej.apps.lveperson;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

import static java.util.Arrays.asList;

/**
 * @author atejano
 */
public class BfsPrintByDepth_ex {
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

            Queue<List<Node>> queue = new ArrayDeque<>();
            queue.add(asList(root));
            while (!queue.isEmpty()) {
                List<Node> nodes = ((ArrayDeque<List<Node>>) queue).pop();
                List<Node> newList = new ArrayList<>();
                nodes.forEach(n -> {
                    System.out.print(n.data);
                    if (n.left!= null) newList.add(n.left);
                    if (n.right!= null) newList.add(n.right);
                });
                System.out.println();
                if (!newList.isEmpty()) queue.add(newList);
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


