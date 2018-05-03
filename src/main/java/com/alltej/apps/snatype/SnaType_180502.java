package com.alltej.apps.snatype;
import javafx.util.Pair;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;
import static org.junit.jupiter.api.Assertions.assertEquals;
/**
 * @author Allan Tejano
 * 5/2/2018
 */
public class SnaType_180502 {

    public List<Pair<Integer, Integer>> findPairs(  int[] input, Integer sum ) {
        List<Pair<Integer, Integer>> pairs = new ArrayList<>(  );
        for (int x = 0; x<input.length; x++) {
            int a = input[x];
            for (int y = x+1; y<input.length; y++) {
                int b = input[y];
                if (( a + b ) == sum) {
                    pairs.add( new Pair<>( a, b ) );
                }
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
