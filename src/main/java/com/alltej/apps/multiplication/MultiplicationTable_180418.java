package com.alltej.apps.multiplication;

import java.util.stream.IntStream;

/**
 * @author Allan Tejano
 * 4/18/2018
 */
public class MultiplicationTable_180418 {
    public static void main( String[] args ) {
        IntStream.rangeClosed( 1, 10 ).forEach( r ->{
            IntStream.rangeClosed( 1,10 ).forEach( c ->{
                System.out.print( c * r + "\t");
            } );
            System.out.println();
        } );
    }
}
