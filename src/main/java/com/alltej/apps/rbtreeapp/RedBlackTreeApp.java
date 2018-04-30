package com.alltej.apps.rbtreeapp;

/**
 * @author Allan Tejano
 * 4/29/2018
 */
public class RedBlackTreeApp {

    public static void main(String args[]) {
        RedBlackNode root = null;
        RedBlackTree redBlackTree = new RedBlackTree();

        redBlackTree.insertNoParent(10);
        redBlackTree.insertNoParent( 15);
        redBlackTree.insertNoParent( -10);
        redBlackTree.insertNoParent( 20);
        redBlackTree.insertNoParent( 30);
        redBlackTree.insertNoParent( 40);
        redBlackTree.insertNoParent( 50);
        redBlackTree.insertNoParent( -15);
        redBlackTree.insertNoParent( 25);
        redBlackTree.insertNoParent( 17);
        redBlackTree.insertNoParent( 21);
        redBlackTree.insertNoParent( 24);
        redBlackTree.insertNoParent( 28);
        redBlackTree.insertNoParent( 34);
        redBlackTree.insertNoParent( 32);
        redBlackTree.insertNoParent( 26);
        redBlackTree.insertNoParent( 35);
        redBlackTree.insertNoParent( 19);

        redBlackTree.printRedBlackTree(root);

        root = redBlackTree.deleteNoParent(50);
        System.out.println(redBlackTree.validateRedBlackTreeDefault());
        redBlackTree.deleteNoParent(40);
        System.out.println(redBlackTree.validateRedBlackTreeDefault());
        redBlackTree.deleteNoParent(-10);
        System.out.println(redBlackTree.validateRedBlackTreeDefault());
        redBlackTree.deleteNoParent(15);
        System.out.println(redBlackTree.validateRedBlackTreeDefault());
        redBlackTree.deleteNoParent(17);
        System.out.println(redBlackTree.validateRedBlackTreeDefault());
        redBlackTree.deleteNoParent(24);
        System.out.println(redBlackTree.validateRedBlackTreeDefault());
        redBlackTree.deleteNoParent(21);
        System.out.println(redBlackTree.validateRedBlackTreeDefault());
        redBlackTree.deleteNoParent(32);
        System.out.println(redBlackTree.validateRedBlackTreeDefault());
        redBlackTree.deleteNoParent(26);
        System.out.println(redBlackTree.validateRedBlackTreeDefault());
        redBlackTree.deleteNoParent(19);
        System.out.println(redBlackTree.validateRedBlackTreeDefault());
        redBlackTree.deleteNoParent(25);
        System.out.println(redBlackTree.validateRedBlackTreeDefault());
        redBlackTree.deleteNoParent(17);
        System.out.println(redBlackTree.validateRedBlackTreeDefault());
        redBlackTree.deleteNoParent(-15);
        System.out.println(redBlackTree.validateRedBlackTreeDefault());
        redBlackTree.deleteNoParent(20);
        System.out.println(redBlackTree.validateRedBlackTreeDefault());
        redBlackTree.deleteNoParent(35);
        System.out.println(redBlackTree.validateRedBlackTreeDefault());
        redBlackTree.deleteNoParent(34);
        System.out.println(redBlackTree.validateRedBlackTreeDefault());
        redBlackTree.deleteNoParent(30);
        System.out.println(redBlackTree.validateRedBlackTreeDefault());
        redBlackTree.deleteNoParent(28);
        System.out.println(redBlackTree.validateRedBlackTreeDefault());
        redBlackTree.deleteNoParent(10);
        System.out.println(redBlackTree.validateRedBlackTreeDefault());
    }
}
