package com.alltej.apps.hdepot;

/**
 * @author Allan Tejano
 * 4/30/2018
 */
public class BSTree {
    private Node root;

    public void insert( int i ) {
        if (root == null) {
            root = Node.of( i );
            return;
        }
        insertNewNode( root, i );
    }

    private void insertNewNode( Node root, int i ) {
        if (root.getValue() > i) {
            if (root.getLeft() == null) {
                root.setLeft( Node.of( i ) );
                return;
            }
            insertNewNode( root.getLeft(), i );
        }
        else{
            if (root.getRight() == null) {
                root.setRight( Node.of( i ) );
                return;
            }
            insertNewNode( root.getRight(), i );
        }
    }
}
