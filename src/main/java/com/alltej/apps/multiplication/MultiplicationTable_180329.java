package com.alltej.apps.multiplication;

import java.util.stream.IntStream;

/**
 * @author Allan Tejano
 * 3/29/2018
 */
public class MultiplicationTable_180329 {
    public static void main( String[] args ) {
        IntStream.rangeClosed( 1, 10 ).forEach( r ->{
            IntStream.rangeClosed( 1,10 ).forEach( c ->{
                System.out.print(r*c + "\t\t");
            } );
            System.out.println();
        } );
    }
}
