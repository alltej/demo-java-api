package com.alltej.apps.misc;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Allan Tejano
 * 5/15/2018
 */
public class FindMissingIntInArray {
    public int findMissingInt( int[] theNumbers ) {

        //1.  find the max number
        //2.  compute the target sum. sum= (max * (max+1)/2
        //3.  calculate sum of int in array
        //4.  missing int = targetSum-calculatedSum



        return 0;
    }

    @Test public void one() {
        int[] theNumbers = { 3, 4, 1, 6, 8, 2, 7, 9,0, 10 };
        int n = findMissingInt( theNumbers );
        assertEquals( 5, n );
    }
    @Test public void two() {
        int[] theNumbers = { 3, 5, 1, 6, 8, 2, 7, 9,0, 10 };
        int n = findMissingInt( theNumbers );
        assertEquals( 4, n );
    }
}
