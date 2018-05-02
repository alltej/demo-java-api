package com.alltej.apps.bfs;

import java.util.Objects;

/**
 * @author Allan Tejano
 * 5/1/2018
 */
public class BSTNode {
    public int getData() {
        return data;
    }

    private int data;
    private BSTNode left, right;

    public static BSTNode of( int data ) {
        return new BSTNode( data );
    }

    private BSTNode( int data ) {
        this.data = data;
    }

    public BSTNode getLeft() {
        return left;
    }

    public void setLeft( BSTNode left ) {
        this.left = left;
    }

    public BSTNode getRight() {
        return right;
    }

    public void setRight( BSTNode right ) {
        this.right = right;
    }

    @Override public boolean equals( Object o ) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        BSTNode bstNode = ( BSTNode ) o;
        return data == bstNode.data && Objects.equals( left, bstNode.left ) && Objects.equals( right, bstNode.right );
    }

    @Override public int hashCode() {

        return Objects.hash( data, left, right );
    }

    @Override public String toString() {
        return "BSTNode{" + "data=" + data + ", left=" + ((left==null)?"null": left.getData()) + ", right=" + (right==null?"null":right.getData()) + '}';
    }
}
