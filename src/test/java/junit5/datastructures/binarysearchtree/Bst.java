package junit5.datastructures.binarysearchtree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Allan Tejano
 * 4/29/2018
 */
public class Bst {
    private Node root;

    public Bst( Node n40 ) {
        root = n40;
    }

    public Node findMinimum() {
        Node currNode = root;
        while ( currNode.getLeft() != null ) {
            currNode = currNode.getLeft();
        }
        return currNode;
    }

    public Node findMaximum() {

        Node currNode = root;
        while ( currNode.getRight() != null ) {
            currNode = currNode.getRight();
        }
        return currNode;
    }

    public List<Node> findPathToValue( int i ) {

        Node currNode = root;
        ArrayList<Node> list = new ArrayList<>();
        list.add( currNode );
        while ( currNode != null ) {
            if (currNode.getValue() == i) {
                break;
            }
            if (i < currNode.getValue()) {
                currNode = currNode.getLeft();
                list.add( currNode );
            } else if (i > currNode.getValue()) {
                currNode = currNode.getRight();
                list.add( currNode );
            }
        }
        return list;
    }

    public List<Node> findPathToValue2( int i ) {

        Node currNode = root;
        ArrayList<Node> list = new ArrayList<>();
        findPathToValueN( currNode,  i , list);

//        printPreOrderRec(currRoot.getLeft());
//        printPreOrderRec(currRoot.getRight());
        return list;
    }

    private void findPathToValueN(Node currentNode, int i , List<Node> list) {
        if (currentNode == null) {
            return;
        }
        list.add( currentNode );
        if (currentNode.getValue() == i) {
            return;
        }
        findPathToValueN( currentNode.getLeft(), i , list);
        findPathToValueN( currentNode.getRight(), i, list );

    }

    public List<Node> findInOrderTraversal() {

        ArrayList<Node> list = new ArrayList<>();
        Node currNode = root;
        //list.add( currNode );
        doInOrderTraversal( currNode, list );
        return  list;
    }

    private void doInOrderTraversal( Node currNode, List<Node> list ) {
        if (currNode == null) {
            return;
        };
        System.out.println(currNode.getValue() + ",");
        list.add( currNode );
        doInOrderTraversal( currNode.getLeft(), list );
        doInOrderTraversal( currNode.getRight(), list );
    }

    public void insertNode( int i ) {
        Node node = new Node( i );

        if (root == null) {
            root = node;
            return;
        }
        insertNewNode( root,  node );
    }

    private void insertNewNode( Node parentNode, Node node ) {

        if (parentNode.getValue() > node.getValue()) {
            if (parentNode.getLeft() == null) {
                parentNode.setLeft( node );
                return;
            }else{
                insertNewNode( parentNode.getLeft(), node );
            }
        }
        else{
            if (parentNode.getRight() == null) {
                parentNode.setRight( node );
                return;
            } else {
                insertNewNode( parentNode.getRight(), node );
            }
        }

    }

    public void printPreOrder() {
        printPreOrderRec(root);
        System.out.println("");
    }

    /**
     * Helper method to recursively print the contents in a Preorder way
     */
    private void printPreOrderRec(Node currRoot) {
        if (currRoot == null) {
            return;
        }
        System.out.print(currRoot.getValue() + ", ");
        printPreOrderRec(currRoot.getLeft());
        printPreOrderRec(currRoot.getRight());
    }

    /**
     * Printing the contents of the tree in an inorder way.
     */
    public void printInorder(){
        printInOrderRec(root);
        System.out.println("");
    }

    /**
     * Helper method to recursively print the contents in an inorder way
     */
    private void printInOrderRec(Node currRoot){
        if ( currRoot == null ){
            return;
        }
        printInOrderRec(currRoot.getLeft());
        System.out.print(currRoot.getValue()+", ");
        printInOrderRec(currRoot.getRight());
    }

    /**
     * Printing the contents of the tree in a Postorder way.
     */
    public void printPostOrder() {
        printPostOrderRec(root);
        System.out.println("");
    }

    /**
     * Helper method to recursively print the contents in a Postorder way
     */
    private void printPostOrderRec(Node currRoot) {
        if (currRoot == null) {
            return;
        }
        printPostOrderRec(currRoot.getLeft());
        printPostOrderRec(currRoot.getRight());
        System.out.print(currRoot.getValue() + ", ");

    }
}
