package com.alltej.apps.rbtreev2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author Allan Tejano
 * 4/30/2018
 */
public class RedBlackTreeApp {

    private RedBlackTree rbt;
    @BeforeEach
    public void setup() {
        rbt = new RedBlackTree();

        rbt.insert(10);
        rbt.insert( 15);
        rbt.insert( -10);
        rbt.insert( 20);
        rbt.insert( 30);
        rbt.insert( 40);
        rbt.insert( 50);
        rbt.insert( -15);
        rbt.insert( 25);
        rbt.insert( 17);
        rbt.insert( 21);
        rbt.insert( 24);
        rbt.insert( 28);
        rbt.insert( 34);
        rbt.insert( 32);
        rbt.insert( 26);
        rbt.insert( 35);
        rbt.insert( 19);
    }

    @Test public void search(  ) {

        boolean search = rbt.search( 28 );
        assertTrue( search );
    }

    @Test public void orders(  ) {
        System.out.println("INORDER:");
        rbt.inorder();
        System.out.println();
        System.out.println("PREORDER");
        rbt.preorder();
        System.out.println();
        System.out.println("POSTORDER");
        rbt.postorder();
    }

    @Test public void count(  ) {

        int nodes = rbt.countNodes();
        assertEquals( 16 , nodes);
    }

    @Test public void test_multiple_variable_value() {
        String current, parent, grand, header = null;
        //header = "Header";
        current = parent = grand = header;
        System.out.println(current);
        System.out.println(parent);
        System.out.println(grand);
        System.out.println(header );
        System.out.println("***");
        parent = "Parent";

        System.out.println(current);
        System.out.println(parent);
        System.out.println(grand);
        System.out.println(header );
    }
}
