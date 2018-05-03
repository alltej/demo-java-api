package com.alltej.apps.bfs;

import java.util.List;

/**
 * @author Allan Tejano
 * 5/1/2018
 */
public class BSTApp {

    //1. Create Binary Search  Tree
    //2. Create method to Insert elements/data of type integer to BST
    //3. Create a method that returns a list of integers (path) given an integer as input

    public static void main( String[] args ) {
        //20, 10, 6, 3, 12, 30, 24, 21, 34, 49,
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert( 20 );
        bst.insert( 10 );
        bst.insert( 6 );
        bst.insert( 3 );
        bst.insert( 12 );
        bst.insert( 30 );
        bst.insert( 24 );
        bst.insert( 21 );
        bst.insert( 34 );
        bst.insert( 49 );
        List<Integer> list = bst.getPreOrderTraversal();
        list.forEach( n -> System.out.print(n + ", ") );
    }
}
