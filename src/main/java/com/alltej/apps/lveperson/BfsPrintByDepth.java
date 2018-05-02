package com.alltej.apps.lveperson;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;

/**
 * @author Allan Tejano
 * 5/2/2018
 */
public class BfsPrintByDepth {

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
}

class Bst {
    Node root;

    public void printDepth() {

        ArrayDeque<List<Node>> q = new ArrayDeque<>();
        q.push( asList(root) );

        while ( !q.isEmpty() ) {
            List<Node> pop = q.pop();
            List<Node> nodeList = new ArrayList<>();
            System.out.println();
            for ( Node n : pop ) {
                System.out.print(n.data);
                if (n.left != null) {
                    nodeList.add( n.left );
                }
                if (n.right != null) {
                    nodeList.add( n.right );
                }
            }
            if (!nodeList.isEmpty())
                q.push( nodeList );
        }
    }
}

class Node {
    String data;
    Node left, right;

    public Node( String data ) {
        this.data = data;
    }
}
