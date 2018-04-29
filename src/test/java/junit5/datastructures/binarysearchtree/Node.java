package junit5.datastructures.binarysearchtree;

import java.util.Objects;

/**
 * @author Allan Tejano
 * 4/29/2018
 */
public class Node {
    private Node left;
    private Node right;
    private Integer value;

    public Node( Integer value ) {
        this.value = value;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft( Node left ) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight( Node right ) {
        this.right = right;
    }

    public Integer getValue() {
        return value;
    }

    @Override public boolean equals( Object o ) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Node node = ( Node ) o;
        return Objects.equals( value, node.value );
    }

    @Override public int hashCode() {

        return Objects.hash( value );
    }

    @Override public String toString() {
        return "Node{" + "value=" + value + '}';
    }
}
