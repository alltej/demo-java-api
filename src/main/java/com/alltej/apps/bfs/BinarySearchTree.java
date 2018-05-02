package com.alltej.apps.bfs;

import java.util.ArrayList;
import java.util.List;


/**
 * @author Allan Tejano
 * 5/1/2018
 */
public class BinarySearchTree {
    public BSTNode getRootNode() {
        return rootNode;
    }

    private BSTNode rootNode;
    public void insert( int data ) {
        if (rootNode == null) {
            rootNode = BSTNode.of( data );
        }
        insertNode( rootNode, data );
    }

    private void insertNode( BSTNode parentNode, int data ) {

        if (parentNode.getData() > data) {
            //insert left
            if (parentNode.getLeft() == null) {
                parentNode.setLeft( BSTNode.of( data ) );
            }
            insertNode(parentNode.getLeft(),  data );
        }
        else if (parentNode.getData() < data) {
            //insert right
            if (parentNode.getRight() == null) {
                parentNode.setRight( BSTNode.of( data ) );
            }
            insertNode(parentNode.getRight(),  data );
        }
    }

    private ArrayList<Integer> nodes;
    public List<Integer> find( int i ) {
        nodes = new ArrayList<>();

        search( rootNode, i );
        return nodes;
    }

    private void search( BSTNode rootNode, int i ) {
        if (rootNode == null) return;
        nodes.add( rootNode.getData() );
        if (rootNode.getData() == i) {
            return;
        }
        else if (rootNode.getData() > i) {
            search( rootNode.getLeft(), i );
        } else  {
            search( rootNode.getRight(), i );
        }
    }

    public int lca( int a, int b ) {

        BSTNode lca = getLca( rootNode, a, b );
        return lca.getData();
    }

    private BSTNode getLca( BSTNode root, int a, int b ) {

        while ( root != null ) {
            if (root.getData() > a && root.getData() > b) {
                root = root.getLeft();
            } else if (root.getData() < a && root.getData() < b) {
                root = root.getRight();
            } else {
                break;
            }
        }
        return root;

    }
}
