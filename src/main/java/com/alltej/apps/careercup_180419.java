package com.alltej.apps;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;

/**
 * @author Allan Tejano
 * 4/19/2018
 */
public class careercup_180419 {

//    Interleave list of lists in Java
//    Example:
//    input = [[1,2,3], [9, 0], [5], [-4,-5,-2,-3,-1]];
//    output = [1,9,5,-4,2,0,-5,3,-2,-3,-1]

//    Intellij Shortcuts
//    iter    Iterate (for each..in)
//    itin    Iterate (for..in)
//    itli    Iterate over a List
//    itar    Iterate elements of array
//    ritar   Iterate elements of array in reverse order

    @Test public void interleave_test() {
        List<Integer> interleave = interleaved(
                asList( asList( 1, 2, 3 ), asList( 9, 0 ), asList( 5 ), asList( -4, -5, -2, -3, -1 ) ) );
        interleave.forEach( System.out::println );
        System.out.println(interleave.size());
    }

    private List<Integer> interleaved( List<List<Integer>> listOfLists ) {
        List<Integer> list = new ArrayList<>();
        int size = listOfLists.size();
        int max = listOfLists.stream().mapToInt( s -> s.size() ).max().getAsInt();

        for ( int j = 0; j < max; j++ ) {
            for ( int i = 0; i < size; i++ ) {
                if (listOfLists.get( i ).size() > j) {
                    list.add( listOfLists.get( i ).get( j ) );
                }
            }
        }
        return list;
    }
}
