package com.alltej.apps.pandor;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.stream.IntStream;

import static java.util.Arrays.asList;
import static java.util.stream.Collectors.toList;
import static org.junit.jupiter.api.Assertions.assertEquals;
/**
 * @author Allan Tejano
 * 4/26/2018
 */
public class PandoraApp_180426 {

    // Write a method that takes two parameters: a list of integers, and a single integer n, and returns
    // the first element in the list that appears n times.  For example
    // list: 7, 9, 4, 1, 9, 2, 4, 0, 6, 4, 3, 9
    // n: 3
    // returns 4

    @Test public void firstElementThatAppearsNTimes_test1() {
        List<Integer> list = asList( 1, 2, 3, 2, 4, 3, 5, 3, 4, 5, 4, 6, 4, 5, 6, 5, 6, 5 );

        assertEquals( 2, firstElementThatAppearsNTimes_usingMapMerge( list, 2).intValue() );
        assertEquals( 3, firstElementThatAppearsNTimes_usingMapMerge( list, 3).intValue() );
        assertEquals( 4, firstElementThatAppearsNTimes_usingMapMerge( list, 4).intValue() );
        assertEquals( 5, firstElementThatAppearsNTimes_usingMapMerge( list, 5).intValue() );
    }

    @Test public void firstElementThatAppearsNTimes_test2() {
        List<Integer> list = asList(7, 9, 4, 1, 9, 2, 4, 0, 6, 4, 3, 9 );

        assertEquals( 4, firstElementThatAppearsNTimes_usingMapMerge( list, 3).intValue() );
    }

    private Integer firstElementThatAppearsNTimes_usingMapMerge(List<Integer> list, Integer nTimes) {
        //write code here
        HashMap<Integer, Integer> map = new HashMap<>();
        for (Integer i: list) {
            Integer count = map.merge( i, 1, ( o, n ) -> o + n );
            if (count.equals( nTimes )) return i;
        } ;

        return null;
    }


    /****** additional *****/


    @Test public void find_first_two_min_values_in_array() {
        int[] nums = new int[] { 11, 36, 175, 72, 45, 21, 231,36,18, 19, 4, 6, 8, 2, 22, 23, 9, 49, 32, 23,45 };

        List<Integer> mins = findFirstNMinInts( nums, 2 );
        assertEquals( asList( 2, 4 ), mins );
    }

    @Test public void findFirstNMinInts_test() {

        int[] nums = new int[]{21,31,41,51,61,71,81,91,11,22,33,44,55,66,77,88,99,98,87,76,65,54,43,32,21,23,34,45,56,67,78,89,32,43,54,65,76,87,98};

        List<Integer> mins = findFirstNMinInts( nums, 10 );
        assertEquals( asList( 11, 21, 21, 22, 23, 31, 32, 32, 33, 34 ), mins );
    }

    @Test public void findFirstNMaxInts_test() {
        int[] nums = new int[]{21,31,41,51,61,71,81,91,11,22,33,44,55,66,77,88,99,98,87,76,65,54,43,32,21,23,34,45,56,67,78,89,32,43,54,65,76,87,98};

        List<Integer> mins = findFirstNMaxInts( nums, 10 );
        assertEquals( asList( 99, 98, 98, 91, 89, 88, 87, 87, 81, 78 ), mins );
    }

    public List<Integer> findFirstNMinInts(int[] nums, int firstN) {

        List<Integer> mins = new ArrayList<>();
        //code here
        IntStream.of( nums )
                .sorted().limit( firstN ).forEach( n ->{
            mins.add( n );
        } );
        return mins;
    }

    public List<Integer> findFirstNMaxInts(int[] nums, int firstN) {

        List<Integer> list = new ArrayList<>();
        //code here
        IntStream.of(nums).boxed().sorted( Comparator.reverseOrder() )
                .limit( firstN )
                .forEach( n ->{
                    list.add( n );
                } );
        return list;
    }
}
