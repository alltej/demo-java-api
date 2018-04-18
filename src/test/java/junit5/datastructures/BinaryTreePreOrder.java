package junit5.datastructures;

import java.time.LocalDateTime;

/**
 * @author Allan Tejano
 * 4/18/2018
 */
public class BinaryTreePreOrder {

    public static class TreeNode {

        private TreeNode leftNode;
        private TreeNode rightNode;

        private Integer data;

        public TreeNode( Integer data, TreeNode leftNode, TreeNode rightNode ) {
            this.leftNode = leftNode;
            this.rightNode = rightNode;
            this.data = data;
        }
    }

    public void preOrder( TreeNode root) {
        if (root != null) {
            System.out.println(root.data);
            preOrder( root.leftNode );
            preOrder( root.rightNode );
        }
    }

    public static void main( String[] args ) {
        System.out.println( LocalDateTime.now());
        TreeNode n10 = new TreeNode(10, null, null);
        TreeNode n30 = new TreeNode(30, null, null);
        TreeNode n20 = new TreeNode(20, n10, n30);


        TreeNode n50 = new TreeNode(50, null, null);
        TreeNode n70 = new TreeNode(70, null, null);
        TreeNode n60 = new TreeNode(60, n50, n70);

        TreeNode n40 = new TreeNode(40, n20, n60);

        BinaryTreePreOrder app = new BinaryTreePreOrder();
        app.preOrder(  n40);
    }
}
