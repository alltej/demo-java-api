package com.alltej.apps.bfs;

import java.util.ArrayList;
import java.util.List;


/**
 * @author Allan Tejano
 * 5/1/2018
 */
public class BinarySearchTree {
    public TreeNode getRootNode() {
        return rootNode;
    }

    private TreeNode rootNode;
    public void insert( int data ) {
        if (rootNode == null) {
            rootNode = TreeNode.of( data );
        }
        insertNode( rootNode, data );
    }

    private void insertNode( TreeNode parentNode, int data ) {

        if (parentNode.getData() > data) {
            //insert left
            if (parentNode.getLeft() == null) {
                parentNode.setLeft( TreeNode.of( data ) );
            }
            insertNode(parentNode.getLeft(),  data );
        }
        else if (parentNode.getData() < data) {
            //insert right
            if (parentNode.getRight() == null) {
                parentNode.setRight( TreeNode.of( data ) );
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

    private void search( TreeNode rootNode, int i ) {
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

        TreeNode lca = getLca( rootNode, a, b );
        return lca.getData();
    }

    private TreeNode getLca( TreeNode root, int a, int b ) {

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

    public List<Integer> getPreOrderTraversal() {
        ArrayList<Integer> list = new ArrayList<>();
        getPreOrderTraversalData( rootNode, list );
        return list;
    }

    private void getPreOrderTraversalData(TreeNode node, ArrayList list) {
        if (node != null) {
            //System.out.print(node.getData() + ", ") ;
            list.add( node.getData() );
            getPreOrderTraversalData( node.getLeft(), list );
            getPreOrderTraversalData( node.getRight(), list );
        }
    }
}
