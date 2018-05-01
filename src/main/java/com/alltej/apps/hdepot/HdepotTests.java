package com.alltej.apps.hdepot;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author Allan Tejano
 * 4/30/2018
 */
public class HdepotTests {

    private ILca lca;
    private Node rootNode;
    private BSTree bst;
    @BeforeEach
    public void setup() {
        bst = new BSTree();
        bst.insert( 10 );
        bst.insert( 25 );
        bst.insert( 78 );
        bst.insert( 78 );

        lca = new LcaV2();

    }

    @Test public void findPath() {

    }

}
