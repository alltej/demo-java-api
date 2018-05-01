package com.alltej.apps.lveperson;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

import static java.util.Arrays.asList;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Allan Tejano
 * 4/30/2018
 */
public class BfsPrint {

    public  static class Node {
        String data;
        Node left;
        Node right;

        public Node( String data ) {
            this.data = data;
        }

        public static Node of( String data ) {
            return new Node( data );
        }
    }

    private Node a;
    private Node b;
    private Node c;
    private Node d;
    private Node e;
    private Node f;
    private Node g;

    @BeforeEach
    @Test public void setup() {
        a = Node.of( "A" );
        b = Node.of( "B" );
        c = Node.of( "C" );
        d = Node.of( "D" );
        e = Node.of( "E" );
        f = Node.of( "F" );
        g = Node.of( "G" );

        a.left = b;
        a.right = c;
        b.left = d;
        c.left = e;
        c.right = f;
        d.left = g;
    }


    @Test public void bfs_print() {
        //output:
        //A
        //BC
        //DEF
        //G

        printBFS( a );
    }

    @Test public void getListOfNodesListByLevel_test() {
        List<List<Node>> nodesListByLevel = getListOfNodesListByLevel( a );
        assertEquals( asList(a), nodesListByLevel.get( 0 ) );
        assertEquals( asList(b, c), nodesListByLevel.get( 1 ) );
        assertEquals( asList(d, e, f), nodesListByLevel.get( 2 ) );
        assertEquals( asList(g), nodesListByLevel.get( 3 ) );
    }

    public static void printBFS(Node a){
        ArrayDeque<List<Node>> queue = new ArrayDeque<>();
        queue.push( asList(a) );
        while(!queue.isEmpty()){
            List<Node> t = queue.pop();
            List<Node> list = new ArrayList<>();
            for ( Node n : t ) {
                if(n.left!=null){
                    list.add( n.left);
                }
                if(n.right!=null){
                    list.add( n.right);
                }
            }
            if (!list.isEmpty()) {
                queue.push( list );
            }
            System.out.println();
            for ( Node elment : t ) {
                System.out.print(elment.data);
            }
        }
    }

    public static List<List<Node>> getListOfNodesListByLevel( Node a ) {
        ArrayDeque<List<Node>> queue = new ArrayDeque<>();
        List<List<Node>> listOfNodesByLevel = new ArrayList<>();
        queue.push( asList( a ) );

        while ( !queue.isEmpty() ) {
            List<Node> pop = queue.pop();
            List<Node> list = new ArrayList<>();
            for ( Node node : pop ) {
                if(node.left!=null){
                    list.add( node.left);
                }
                if(node.right!=null){
                    list.add( node.right);
                }
            }
            if (!list.isEmpty()){
                queue.push( list );

            }
            listOfNodesByLevel.add( pop );
        }
        return listOfNodesByLevel;
    }
}
