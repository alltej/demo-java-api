package com.alltej.apps;

import java.util.stream.IntStream;

/**
 * @author Allan Tejano
 * 3/4/2018
 */
public class MultiplicationTable2 {
    public static void main( String[] args ) {
        //printMultiplicationTable_orig();

        IntStream.rangeClosed( 1,10 ).forEach( x ->{
            StringBuilder s = new StringBuilder( x );
            IntStream.rangeClosed( 1,10 ).forEach( y ->{
                final Integer product = x*y;
                //System.out.println( product + "    ");
                s.append( product ).append( "\t\t" );
            } );
            System.out.println(s.toString());
        } );

    }
    private static void printMultiplicationTable_orig() {
        final int MULTIPLIER_MAX = 9;
        final int PAD_SIZE = 5;

        StringBuilder header = new StringBuilder( padRight( "" , PAD_SIZE, " " ));
        IntStream.rangeClosed( 1, MULTIPLIER_MAX )
                .forEach( c -> {
                    header.append( padRight( String.valueOf( c ) , PAD_SIZE, " " ));
                } );
        System.out.println(header);

        IntStream.rangeClosed( 1, MULTIPLIER_MAX )
                .forEach( row -> {
                    StringBuilder sb = new StringBuilder( padRight( String.valueOf( row ) , PAD_SIZE, " " ) );
                    IntStream.rangeClosed( 1, MULTIPLIER_MAX )
                            .forEach( m -> {
                                final Integer product = row*m;
                                sb.append( padRight( String.valueOf( product ) , PAD_SIZE, " " ));
                            } );
                    System.out.println(sb);
                } );
    }

    private static String padRight( final String s, final int i, final String padChar ) {
        StringBuilder sb = new StringBuilder( s );
        while ( sb.length() < i ) {
            sb.append( padChar);
        }
        return sb.toString();
    }
}


//        1		2		3		4		5		6		7		8		9		10
//        2		4		6		8		10		12		14		16		18		20
//        3		6		9		12		15		18		21		24		27		30
//        4		8		12		16		20		24		28		32		36		40
//        5		10		15		20		25		30		35		40		45		50
//        6		12		18		24		30		36		42		48		54		60
//        7		14		21		28		35		42		49		56		63		70
//        8		16		24		32		40		48		56		64		72		80
//        9		18		27		36		45		54		63		72		81		90
//        10	20		30		40		50		60		70		80		90		100
