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

    //    private Node getNodeWithMinValue( Node currNode ) {
//        if (root == null) return root;
//        while ( root.getLeft() != null ) {
//            getNodeWithMinValue( root.getLeft() );
//        }
//        return root;
//    }
}
