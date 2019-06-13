package com.alltej.apps.snatype;

import javafx.util.Pair;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.Arrays.asList;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Allan Tejano
 * 5/7/2018
 */
public class SnaType_soln {
    /***
     * Given an array of int, return list of pairs whose sum is equal to param sum.
     * @param input
     * @param sum
     * @return
     */
    public List<Pair<Integer, Integer>> findPairs(  int[] input, Integer sum ) {
        HashSet<Integer> integers = new HashSet<>();
        List<Pair<Integer, Integer>> pairs = new ArrayList<>();
        Set<Integer> collect = Arrays.stream(input).boxed().collect(Collectors.toSet());
        collect.forEach(c -> {
            if (!integers.contains(c)) {
                Integer y = sum - c;
                if (c!=y && !integers.contains(y) && collect.contains(y)) {
                    pairs.add(new Pair<>(c, y));
                    integers.add(c);
                    integers.add(y);
                }
            }
        });
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
