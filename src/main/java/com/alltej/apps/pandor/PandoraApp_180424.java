package com.alltej.apps.pandor;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.util.Arrays.asList;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;
import static org.junit.jupiter.api.Assertions.assertEquals;
/**
 * @author Allan Tejano
 * 4/24/2018
 */

// Write a method that takes two parameters: a list of integers, and a single integer n, and returns
// the first element in the list that appears n times.  For example
// list: 7, 9, 4, 1, 9, 2, 4, 0, 6, 4, 3, 9
// n: 3
// returns 4
public class PandoraApp_180424 {
    @Test public void using_map_merge() {
        List<Integer> list = asList( 1, 2, 3, 2, 4, 3, 5, 3, 4, 5, 4, 6, 4, 5, 6, 5, 6, 5 );

        assertEquals( 2, firstElementThatAppearsNTimes_usingMapMerge( list, 2).intValue() );
        assertEquals( 3, firstElementThatAppearsNTimes_usingMapMerge( list, 3).intValue() );
        assertEquals( 4, firstElementThatAppearsNTimes_usingMapMerge( list, 4).intValue() );
        assertEquals( 5, firstElementThatAppearsNTimes_usingMapMerge( list, 5).intValue() );
    }

    @Test public void run_example() {
        List<Integer> list = asList(7, 9, 4, 1, 9, 2, 4, 0, 6, 4, 3, 9 );

        assertEquals( 4, firstElementThatAppearsNTimes_usingMapMerge( list, 3).intValue() );
    }

    private Integer firstElementThatAppearsNTimes_usingMapMerge(List<Integer> list, Integer nTimes) {
        //write code here
        HashMap<Integer, Integer> map = new HashMap<>();
        Map<Integer, Long> collect = list.stream().collect( groupingBy( Integer::intValue, counting() ) );
        for ( int i : list ) {
            Integer merge = map.merge( i, 1, ( o, n ) -> o + n );
            if (merge == nTimes) return i;
        }
        return null;
    }
}
