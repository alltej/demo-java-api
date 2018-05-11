package com.alltej.apps.snatype;

import javafx.util.Pair;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import static java.util.Arrays.asList;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Allan Tejano
 * 5/7/2018
 */
public class SnaType_180507 {

    //use hash??
    public List<Pair<Integer, Integer>> findPairs(  int[] input, Integer sum ) {

        HashSet<Integer> set = new HashSet<>();
        for ( Integer i: input) {
            if (i > sum) continue;
            set.add( i );
        }
        ArrayList<Pair<Integer, Integer>> pairs = new ArrayList<>();
        HashSet<Integer> map = new HashSet<>();
        for ( Integer x : set ) {
            int y = sum - x;
            if (set.contains( y )) {
                pairs.add( new Pair<>( x, y ) );
                map.add( x );
                map.add( y );
            }
        }
        return pairs;
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
