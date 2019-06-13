package com.alltej.apps.snatype;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Allan Tejano
 * 4/20/2018
 */


public class SnaType_prob_v2 {
    /***
     * Given an array of int, return key/vals(map) whose sum is equal to param sum.
     * @param input
     * @param sum
     * @return
     *
     * [1,2,3,4,5,6,7], 5 -> [(1,4), (2,3)]
     */
    public Map<Integer, Integer> findPairs(  int[] input, Integer sum ) {
        return new HashMap<>();
    }

    @Test public void sum_simple() {
        int[] input = {1, 2, 3, 4, 5, 6, 7};
        Map<Integer, Integer> pairs = findPairs( input, 5 );
        System.out.println(pairs);
        assertEquals(4, pairs.size());
        assertEquals(4, pairs.get(1).intValue());
        assertEquals(1, pairs.get(4).intValue());
        assertEquals(3, pairs.get(2).intValue());
        assertEquals(2, pairs.get(3).intValue());
        assertEquals(null, pairs.get(5));
    }

    @Test public void sum_with_repeated_values() {
        int[] input = {9, 7, 5, 3, 1, 2, 4, 6, 8, 9, 7, 5, 3, 1, 2, 4, 6, 8};
        Map<Integer, Integer> pairs = findPairs( input, 8 );
        System.out.println(pairs);
        assertEquals(6, pairs.size());
        assertEquals(6, pairs.get(2).intValue());
        assertEquals(2, pairs.get(6).intValue());
        assertEquals(3, pairs.get(5).intValue());
        assertEquals(5, pairs.get(3).intValue());
        assertEquals(1, pairs.get(7).intValue());
        assertEquals(7, pairs.get(1).intValue());
        assertEquals(null, pairs.get(9));
    }

    @Test public void sum_w_neg() {
        int[] input = {-9,-8,-7,-6,-5,-4,-3,-2,-1,0,1,2,3,4,5,6,7,8,9};
        Map<Integer, Integer> pairs = findPairs( input, 5);
        System.out.println(pairs);
        assertEquals(14, pairs.size());
        assertEquals(5, pairs.get(0).intValue());
        assertEquals(9, pairs.get(-4).intValue());
        assertEquals(-2, pairs.get(7).intValue());
    }
}
