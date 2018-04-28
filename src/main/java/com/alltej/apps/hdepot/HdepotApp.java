package com.alltej.apps.hdepot;


import java.util.Collections;
import java.util.List;


/**
 * @author Allan Tejano
 * 4/28/2018
 */
public class HdepotApp {
    public static void main( String[] args ) {
        Node n5 = new Node( 5 );
        Node n3 = new Node( 3 );
        Node n2 = new Node( 2 );
        Node n7 = new Node( 7 );
        Node n4= new Node( 4 );
        Node n6= new Node( 6 );
        Node n8= new Node( 8 );
        Node n12= new Node( 12 );

        n5.setLeft( n3 );
        n5.setRight( n7 );
        n3.setLeft( n2 );
        n7.setLeft( n4 );
        n7.setRight( n6 );
        n4.setLeft(n8 );
        n4.setRight(n12 );
        //sampleA( n5 );

        sampleB( n5, 2, 7 );
        sampleB( n5, 4, 6 );
        sampleB( n5, 3, 12);
        sampleB( n5, 8, 6);
        sampleB( n5, 8, 12);
    }

    public static void sampleB( Node n5, Integer a, Integer b ) {
        Lca lca = new Lca();
        Integer lcaData = lca.findLcaData( n5, a, b );
        System.out.println(lcaData);
    }

    private static void sampleA( Node n5 ) {
        Lca lca = new Lca();
        List<Integer> pathA = lca.findPath( n5, 2 );
        System.out.println("*******");
        pathA.forEach( System.out::println );

        List<Integer> pathB = lca.findPath( n5, 7 );
        System.out.println("*******");
        pathB.forEach( System.out::println );

        Collections.reverse( pathA );
        Collections.reverse( pathB );
        int min = 0;
        for ( Integer a : pathA ) {
            int indexOf = pathB.indexOf( a );
            if (indexOf > 0 && indexOf < min) {
                min = indexOf;
            }
        }
        System.out.println(min);
    }

}



