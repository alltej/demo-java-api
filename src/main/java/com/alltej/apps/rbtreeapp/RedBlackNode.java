package com.alltej.apps.rbtreeapp;

/**
 * @author Allan Tejano
 * 4/29/2018
 */
public class RedBlackNode {

    int data;
    Color color;
    RedBlackNode left;
    RedBlackNode right;
    RedBlackNode parent;
    boolean isNullLeaf;

    
    public RedBlackNode() {
        
    }
    
    public static RedBlackNode createBlackNode( int data ) {
        RedBlackNode node = new RedBlackNode();
        node.data = data;
        node.color = Color.BLACK;
        node.left = createNullLeafRedBlackNode(node);
        node.right = createNullLeafRedBlackNode(node);
        return node;
    }

    private static RedBlackNode createNullLeafRedBlackNode(RedBlackNode parent) {
        RedBlackNode leaf = new RedBlackNode();
        leaf.color = Color.BLACK;
        leaf.isNullLeaf = true;
        leaf.parent = parent;
        return leaf;
    }

    public static RedBlackNode createRedNode( RedBlackNode parent, int data ) {
        RedBlackNode node = new RedBlackNode();
        node.data = data;
        node.color = Color.RED;
        node.parent = parent;
        node.left = createNullLeafRedBlackNode(node);
        node.right = createNullLeafRedBlackNode(node);
        return node;
    }

    public enum Color {
        RED,
        BLACK
    }


}
