package com.alltej.apps.pandor;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.Arrays.asList;

/**
 * @author Allan Tejano
 * 4/18/2018
 */


// Write a method that takes two parameters: a list of integers, and a single integer n, and returns
// the first element in the list that appears n times.  For example
// list: 7, 9, 4, 1, 9, 2, 4, 0, 6, 4, 3, 9
// n: 3
// returns 4
public class PandoraApp {
    public static void main( String[] args ) {
        Integer element = firstElementThatAppearsNTimes_usingMapMerge(asList(4,3,4,1,2,3,2,1,3,4,4), 3);
        System.out.println(element);
    }

    static Integer firstElementThatAppearsNTimes_usingStream(List<Integer> list, Integer n) {
        Map<Integer, Long> map = list.stream()
                .collect( Collectors.groupingBy( Integer::intValue, Collectors.counting() ) );

        for ( Map.Entry<Integer, Long> c : map.entrySet() ) {
            if (c.getValue()==Long.valueOf( n )) {
                return c.getKey();
            }
        }

        return null;
    }

//    static Integer firstElementThatAppearsNTimes_usingMapMerge(List<Integer> list, Integer nTimes) {
//        Map<Integer, Integer> map = new HashMap<>();
//        for ( Integer i : list ) {
//            map.merge( i, 1, ( o, n ) -> o + n );
//            Integer times = map.get( i );
//            if (times == nTimes)
//                return i;
//        }
//        return null;
//    }
//
    static Integer firstElementThatAppearsNTimes_usingMapMerge(List<Integer> list, Integer nTimes) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for ( Integer i : list ) {
            map.merge( i, 1, ( o, n ) -> o + 1 );
            Integer times = map.get( i );
            if (times == nTimes) {
                return i;
            }
        }
        return null;
    }
}
