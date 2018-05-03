package com.alltej.apps.bfs;

import org.junit.jupiter.api.Test;

import java.util.List;

import static java.util.Arrays.asList;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Allan Tejano
 * 5/1/2018
 */
class BinarySearchTreeTest {

    @Test public void on_insert_creates_root_if_no_root_exists() {
        BinarySearchTree tree = new BinarySearchTree();
        tree.insert( 10 );
        assertEquals( TreeNode.of( 10 ) , tree.getRootNode());
    }

    @Test public void on_insert_if_data_lt_root_data_creates_node_in_left() {
        BinarySearchTree tree = new BinarySearchTree();
        tree.insert( 10 );
        tree.insert( 5 );
        assertEquals( TreeNode.of( 5 ) , tree.getRootNode().getLeft());
    }

    @Test public void on_insert_if_data_gt_root_data_creates_node_in_right() {
        BinarySearchTree tree = new BinarySearchTree();
        tree.insert( 10 );
        tree.insert( 15 );
        assertEquals( TreeNode.of( 15 ) , tree.getRootNode().getRight());
    }

    @Test public void create_node_at_multi_level_creates_node() {
        BinarySearchTree tree = new BinarySearchTree();
        tree.insert( 10 );
        tree.insert( 12 );
        tree.insert( 8 );
        tree.insert( 6 );
        tree.insert( 14 );
        tree.insert( 2 );
        tree.insert( 13 );
        assertEquals( TreeNode.of( 2 ) , tree.getRootNode().getLeft().getLeft().getLeft());
        assertEquals( TreeNode.of( 13 ) , tree.getRootNode().getRight().getRight().getLeft());
    }

    @Test public void find_node_returns_list_of_nodes() {
        BinarySearchTree tree = new BinarySearchTree();
        tree.insert( 10 );
        tree.insert( 12 );
        tree.insert( 8 );
        tree.insert( 6 );
        tree.insert( 14 );
        tree.insert( 2 );
        tree.insert( 13 );
        List<Integer> nodes = tree.find(13);
        assertEquals( asList(10,12,14,13), nodes );
    }

    @Test public void find_lca() {
        BinarySearchTree tree = new BinarySearchTree();
        tree.insert( 10 );
        tree.insert( 12 );
        tree.insert( 8 );
        tree.insert( 6 );
        tree.insert( 14 );
        tree.insert( 2 );
        tree.insert( 7 );
        tree.insert( 13 );
        assertEquals( 14, tree.lca(13,14) );
        assertEquals( 10, tree.lca(2,14) );
        assertEquals( 8, tree.lca(2,8) );
        assertEquals( 6, tree.lca(2,7) );
    }

    @Test public void preOrderTraversal_correct() {
        BinarySearchTree tree = new BinarySearchTree();
        tree.insert( 10 );
        tree.insert( 12 );
        tree.insert( 8 );
        tree.insert( 6 );
        tree.insert( 14 );
        tree.insert( 2 );
        tree.insert( 7 );
        tree.insert( 13 );
        //assertEquals( asList(), tree.getPreOrderTraversal() );
        assertEquals( 8, tree.getRootNode().getLeft().getData() );
        assertEquals( 12, tree.getRootNode().getRight().getData() );
        assertEquals( 6, tree.getRootNode().getLeft().getLeft().getData() );
        assertEquals( 14, tree.getRootNode().getRight().getRight().getData() );
        assertEquals( 2, tree.getRootNode().getLeft().getLeft().getLeft().getData() );
        List<Integer> preOrderTraversal = tree.getPreOrderTraversal();
        preOrderTraversal.forEach( n -> System.out.print(n + ", ") );
        assertEquals( asList(10, 8, 6, 2, 7, 12, 14, 13), preOrderTraversal );
                    //10
          //8                 //12
        //6                         //14
    //2     //7                 //13
    }

    @Test public void preOrderTraversal_verify_from_g2g() {
        //REF: https://www.geeksforgeeks.org/tree-traversals-inorder-preorder-and-postorder/
        BinarySearchTree tree = new BinarySearchTree();
        tree.insert( 1 );
        tree.getRootNode().setLeft( new TreeNode(2) );
        tree.getRootNode().setRight( new TreeNode(3) );
        tree.getRootNode().getLeft().setLeft( new TreeNode(4)  );
        tree.getRootNode().getLeft().setRight(new TreeNode(5)  );
        List<Integer> preOrderTraversal = tree.getPreOrderTraversal();
        preOrderTraversal.forEach( n -> System.out.print(n + ", ") );
        assertEquals( asList(1,2,4,5,3), preOrderTraversal );
    }
}
