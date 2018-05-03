package com.alltej.apps.bfs;

import java.util.Objects;

/**
 * @author Allan Tejano
 * 5/1/2018
 */
public class TreeNode {
    public int getData() {
        return data;
    }

    private int data;
    private TreeNode left, right;

    public static TreeNode of( int data ) {
        return new TreeNode( data );
    }

    public TreeNode( int data ) {
        this.data = data;
    }

    public TreeNode getLeft() {
        return left;
    }

    public void setLeft( TreeNode left ) {
        this.left = left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setRight( TreeNode right ) {
        this.right = right;
    }

    @Override public boolean equals( Object o ) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        TreeNode bstNode = ( TreeNode ) o;
        return data == bstNode.data && Objects.equals( left, bstNode.left ) && Objects.equals( right, bstNode.right );
    }

    @Override public int hashCode() {

        return Objects.hash( data, left, right );
    }

    @Override public String toString() {
        return "TreeNode{" + "data=" + data + ", left=" + ((left==null)?"null": left.getData()) + ", right=" + (right==null?"null":right.getData()) + '}';
    }
}
