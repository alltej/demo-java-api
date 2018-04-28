package com.alltej.apps.hdepot;

/**
 * @author Allan Tejano
 * 4/28/2018
 */
public class Node {
    private boolean visited;
    public Node getLeft() {
        return left;
    }

    public void setLeft( Node left ) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight( Node right ) {
        this.right = right;
    }

    public int getValue() {
        return value;
    }

    public void setValue( int value ) {
        this.value = value;
    }

    public Node(int value ) {
        this.value = value;
    }

    private Node left;
    private Node right;
    private int value;

    public boolean isVisited() {
        return visited;
    }

    public void setVisited( boolean visited ) {
        this.visited = visited;
    }
}
