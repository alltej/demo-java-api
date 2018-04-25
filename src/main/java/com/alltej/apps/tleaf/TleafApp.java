package com.alltej.apps.tleaf;

import java.util.List;
import java.util.stream.Stream;

import static java.util.Arrays.asList;
import static java.util.stream.Collectors.*;

/**
 * @author Allan Tejano
 * 4/20/2018
 */

//3)Write a Java method call sortUnique that takes an array of strings as an input and returns an array sorted
//        with any duplicates removed. Your solution should be case insensitive in respect to sorting and duplicate
//        detection.
public class TleafApp {

    public static void main( String[] args ) {
//        String[] values = {"Red", "Blue", "yellow", "Green", "BLUE"};
//        asList( values ).stream().forEach( System.out::println );
//        System.out.println("****");
//        asList( sortUnique( values ) ).stream().forEach( System.out::println );

        String[] values = {"Red", "Blue", "yellow", "Green","BLUE"};
        String[] sortedValues = sortUnique(values);
        for (String s : sortedValues) {
            System.out.println(s);
        }
    }

    static String[] sortUnique( String[] values ) {
        List<String> strings = asList( values );
        return strings.stream().distinct().sorted().toArray(String[]::new);
    }
}
