package com.alltej.apps.pandor;

import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.Arrays.asList;
import static java.util.stream.Collectors.toList;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Allan Tejano
 * 4/25/2018
 */
public class PandoraAppV2 {
    @Test public void find_first_two_min_values_in_array() {
        int[] nums = new int[] { 11, 36, 175, 72, 45, 21, 231,36,18, 19, 4, 6, 8, 2, 22, 23, 9, 49, 32, 23,45 };

        List<Integer> mins = findFirstNMinInts( nums, 2 );
        assertEquals( asList( 2, 4 ), mins );
    }

    @Test public void findFirstNMinInts_test() {
        //int[] nums = generateRandomIntsWith( 100, 1000 );
        int[] nums = new int[]{21,31,41,51,61,71,81,91,11,22,33,44,55,66,77,88,99,98,87,76,65,54,43,32,21,23,34,45,56,67,78,89,32,43,54,65,76,87,98};
        //IntStream.of(nums).forEach( System.out::println );

        List<Integer> mins = findFirstNMinInts( nums, 10 );
        assertEquals( asList( 11, 21, 21, 22, 23, 31, 32, 32, 33, 34 ), mins );
    }

    @Test public void findFirstNMaxInts_test() {
        //int[] nums = generateRandomIntsWith( 100, 1000 );
        int[] nums = new int[]{21,31,41,51,61,71,81,91,11,22,33,44,55,66,77,88,99,98,87,76,65,54,43,32,21,23,34,45,56,67,78,89,32,43,54,65,76,87,98};
        //IntStream.of(nums).forEach( System.out::println );

        List<Integer> mins = findFirstNMaxInts( nums, 10 );
        assertEquals( asList( 99, 98, 98, 91, 89, 88, 87, 87, 81, 78 ), mins );
    }

    public List<Integer> findFirstNMinInts(int[] nums, int firstN) {

        List<Integer> mins = new ArrayList<>();
        IntStream.of( nums )
                .sorted().limit( firstN ).forEach( n ->{
            mins.add( n );
        } );
        return mins;
    }

    public List<Integer> findFirstNMaxInts(int[] nums, int firstN) {

        List<Integer> mins = new ArrayList<>();
        IntStream intStream1 = Arrays.stream(nums);
        intStream1.boxed()
                .sorted( Comparator.reverseOrder()).limit( firstN ).forEach( n -> {
            mins.add( n );
        } );
        return mins;
    }
}
