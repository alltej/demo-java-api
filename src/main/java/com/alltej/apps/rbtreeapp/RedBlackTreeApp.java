package com.alltej.apps.rbtreeapp;

/**
 * @author Allan Tejano
 * 4/29/2018
 */
public class RedBlackTreeApp {

    public static void main(String args[]) {
        RedBlackNode root = null;
        RedBlackTree redBlackTree = new RedBlackTree();

        root = redBlackTree.insert(root, 10);
        root = redBlackTree.insert(root, 15);
        root = redBlackTree.insert(root, -10);
        root = redBlackTree.insert(root, 20);
        root = redBlackTree.insert(root, 30);
        root = redBlackTree.insert(root, 40);
        root = redBlackTree.insert(root, 50);
        root = redBlackTree.insert(root, -15);
        root = redBlackTree.insert(root, 25);
        root = redBlackTree.insert(root, 17);
        root = redBlackTree.insert(root, 21);
        root = redBlackTree.insert(root, 24);
        root = redBlackTree.insert(root, 28);
        root = redBlackTree.insert(root, 34);
        root = redBlackTree.insert(root, 32);
        root = redBlackTree.insert(root, 26);
        root = redBlackTree.insert(root, 35);
        root = redBlackTree.insert(root, 19);

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
