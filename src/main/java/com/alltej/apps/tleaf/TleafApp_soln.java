package com.alltej.apps.tleaf;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static java.util.Arrays.asList;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Allan Tejano
 * 4/20/2018
 */


public class TleafApp_soln {
    /***
     * Problem: Write a Java method call sortUnique that takes an array of strings as an input and returns an array sorted
     *      with any duplicates removed. Your solution should be case insensitive in respect to sorting and duplicate
     *      detection.
     * @param values
     * @return
     */
    static String[] sortUnique( String[] values) {
        List<String> strings = asList( values );
        return strings.stream().map(s -> s.toLowerCase()).distinct().sorted().toArray(String[]::new);
    }

    @Test
    public void sort_simple() {
        String[] values = {"Red", "Blue", "yellow", "Green","BLUE", "YelloW"};
        String[] sortedArr = sortUnique(values);
        String[] expected = {"blue", "green", "red", "yellow"};
        assertEquals(Arrays.toString(expected), Arrays.toString(sortedArr));
    }
}
