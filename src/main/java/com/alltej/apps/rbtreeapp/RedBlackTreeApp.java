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

        root = redBlackTree.delete(root, 50);
        System.out.println(redBlackTree.validateRedBlackTree(root));
        root = redBlackTree.delete(root, 40);
        System.out.println(redBlackTree.validateRedBlackTree(root));
        root = redBlackTree.delete(root, -10);
        System.out.println(redBlackTree.validateRedBlackTree(root));
        root = redBlackTree.delete(root, 15);
        System.out.println(redBlackTree.validateRedBlackTree(root));
        root = redBlackTree.delete(root, 17);
        System.out.println(redBlackTree.validateRedBlackTree(root));
        root = redBlackTree.delete(root, 24);
        System.out.println(redBlackTree.validateRedBlackTree(root));
        root = redBlackTree.delete(root, 21);
        System.out.println(redBlackTree.validateRedBlackTree(root));
        root = redBlackTree.delete(root, 32);
        System.out.println(redBlackTree.validateRedBlackTree(root));
        root = redBlackTree.delete(root, 26);
        System.out.println(redBlackTree.validateRedBlackTree(root));
        root = redBlackTree.delete(root, 19);
        System.out.println(redBlackTree.validateRedBlackTree(root));
        root = redBlackTree.delete(root, 25);
        System.out.println(redBlackTree.validateRedBlackTree(root));
        root = redBlackTree.delete(root, 17);
        System.out.println(redBlackTree.validateRedBlackTree(root));
        root = redBlackTree.delete(root, -15);
        System.out.println(redBlackTree.validateRedBlackTree(root));
        root = redBlackTree.delete(root, 20);
        System.out.println(redBlackTree.validateRedBlackTree(root));
        root = redBlackTree.delete(root, 35);
        System.out.println(redBlackTree.validateRedBlackTree(root));
        root = redBlackTree.delete(root, 34);
        System.out.println(redBlackTree.validateRedBlackTree(root));
        root = redBlackTree.delete(root, 30);
        System.out.println(redBlackTree.validateRedBlackTree(root));
        root = redBlackTree.delete(root, 28);
        System.out.println(redBlackTree.validateRedBlackTree(root));
        root = redBlackTree.delete(root, 10);
        System.out.println(redBlackTree.validateRedBlackTree(root));
    }
}
