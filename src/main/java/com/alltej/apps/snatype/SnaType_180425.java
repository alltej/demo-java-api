package com.alltej.apps.snatype;

import javafx.util.Pair;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Allan Tejano
 * 4/25/2018
 */
public class SnaType_180425 {

    public List<Pair<Integer, Integer>> findPairs(  int[] input, int sum ) {
        List<Pair<Integer, Integer>> list = new ArrayList<>();
        for ( int x = 0; x < input.length; x++ ) {
            for ( int y = x+1; y < input.length; y++ ) {
                if (( input[x] + input[y] ) == sum) {
                    list.add( new Pair<>( input[x], input[y] ));
                }
            }
        }
        return list;
    }

    @Test public void sum_of_5() {
        int[] input = new int[]{1,2,3,4,5,6,7};
        List<Pair<Integer, Integer>> pairs = findPairs( input, 5 );
        System.out.println(pairs);
        assertEquals( asList( new Pair( 1, 4 ), new Pair( 2, 3 ) ), pairs );
    }

    @Test public void sum_of_8() {
        int[] input = new int[]{1,2,3,4,5,6,7};
        List<Pair<Integer, Integer>> pairs = findPairs( input, 8 );
        System.out.println(pairs);
        assertEquals( asList( new Pair( 1, 7 ), new Pair( 2, 6 ),new Pair( 3,5 ) ), pairs );
    }
}
