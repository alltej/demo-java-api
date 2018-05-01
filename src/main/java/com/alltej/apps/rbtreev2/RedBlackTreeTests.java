package com.alltej.apps.rbtreev2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author Allan Tejano
 * 4/30/2018
 */
public class RedBlackTreeTests {

    private RedBlackTree rbt;

    @BeforeEach
    public void setup() {
        rbt = new RedBlackTree();

        rbt.insert(10);
        rbt.insert( 20);
        rbt.insert( 30);
        rbt.insert( 15);


    }

    @Test public void search() {
        boolean search = rbt.search( 30 );
    }
}
