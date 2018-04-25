package com.alltej.apps;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Allan Tejano
 * 4/22/2018
 */
public class careercup_180422 {

    public int findMissingInt( int[] theNumbers ) {

        int sumOfAllNumbers = 0;
        int sumOfNumbersPresent = 0;
        int blankSpace = 0;

        for (int i = 0; i < theNumbers.length; i++) {
            sumOfAllNumbers += i + 1;
            sumOfNumbersPresent += theNumbers[i];
            if (theNumbers[i] == 0)
                blankSpace = i;
        }
        //System.out.println("Missing number = " + (sumOfAllNumbers - sumOfNumbersPresent) + " at location " + blankSpace +" of the array");
        System.out.println(sumOfAllNumbers);
        System.out.println(sumOfNumbersPresent);
        return (sumOfAllNumbers - sumOfNumbersPresent);
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
