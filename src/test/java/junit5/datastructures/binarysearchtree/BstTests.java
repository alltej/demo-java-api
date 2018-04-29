package junit5.datastructures.binarysearchtree;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static java.util.Arrays.asList;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Allan Tejano
 * 4/29/2018
 */
public class BstTests {

    private Bst bst ;
    private Node n40;
    private Node n25;
    private Node n78;
    private Node n10;
    private Node n32;
    private Node n50;
    private Node n93;
    private Node n3 ;
    private Node n17;
    private Node n30;
    private Node n38;

    @BeforeEach
    public void setup() {
        n40 = new Node( 40 );
        n25 = new Node( 25 );
        n78 = new Node( 78 );
        n10 = new Node( 10 );
        n32 = new Node( 32 );
        n50 = new Node( 50 );
        n93 = new Node( 93 );
        n3 = new Node( 3 );
        n17 = new Node( 17 );
        n30 = new Node( 30 );
        n38 = new Node( 38 );

        n40.setLeft( n25 );
        n40.setRight( n78 );
        n25.setLeft( n10 );
        n25.setRight( n32 );
        n10.setLeft( n3 );
        n10.setRight( n17 );
        n32.setLeft( n30 );
        n32.setRight( n38 );
        n78.setLeft( n50 );
        n78.setRight( n93 );

        bst = new Bst(n40);
    }

    @Test public void findMinValue() {
        Node minNode = bst.findMinimum();
        assertEquals( Integer.valueOf( 3 ), minNode.getValue() );
    }

    @Test public void findMaxValue() {
        Node maxNode = bst.findMaximum();
        assertEquals( Integer.valueOf( 93 ), maxNode.getValue() );
    }

    @Test public void findPathToValue() {
        List<Node> nodes1 = bst.findPathToValue( 17 );
        assertEquals( asList(n40, n25,n10, n17), nodes1 );

        List<Node> nodes2 = bst.findPathToValue( 38 );
        assertEquals( asList(n40, n25,n32, n38), nodes2 );
    }

    @Test public void inOrderTranversal() {
        List<Node> nodes1 = bst.findInOrderTraversal(  );
        //assertEquals( asList(n40, n25,n10, n17), nodes1 );
        nodes1.forEach( System.out::println );
    }

    @Test public void insertNode() {
        //Node newNode = new Node( 64 );
        bst.insertNode( 64 );
        List<Node> nodes1 = bst.findInOrderTraversal(  );
        nodes1.forEach( System.out::println );
    }


    @Test public void preOrderTranversal() {
        System.out.println("preOrderTranversal");
        bst.printPreOrder(  );
    }

    @Test public void printInorderTraversal() {
        System.out.println("printInorderTraversal");
        bst.printInorder(  );
    }
    @Test public void printPostorderTraversal() {
        System.out.println("printPostorderTraversal");
        bst.printPostOrder(  );
    }

    @Test public void printAllTraversal() {
        System.out.println("preOrderTranversal");
        bst.printPreOrder(  );
        System.out.println("printInorderTraversal");
        bst.printInorder(  );
        System.out.println("printPostorderTraversal");
        bst.printPostOrder(  );
    }

}
