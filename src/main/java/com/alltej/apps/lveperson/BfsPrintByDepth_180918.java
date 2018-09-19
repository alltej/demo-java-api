package com.alltej.apps.lveperson;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static java.util.Arrays.asList;

public class BfsPrintByDepth_180918 {
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
            //visit
            //traverse_left
            //traverse_right

            LinkedList<List<Node>> q = new LinkedList<>();
            q.add(asList(root));
            while (!q.isEmpty()) {
                List<Node> nodeList = ((LinkedList<List<Node>>) q).pop();
                ArrayList<Node> childNodes = new ArrayList<>();
                nodeList.forEach(n ->{
                    if (n.left != null) childNodes.add(n.left);
                    if (n.right != null) childNodes.add(n.right);
                    System.out.print(n.name);
                });
                if (!childNodes.isEmpty()) q.add(childNodes);
                System.out.println();
            }
        }
    }

    static class Node {
        String name;
        Node left, right;

        public Node( String name ) {
            this.name = name;
        }
    }

}

