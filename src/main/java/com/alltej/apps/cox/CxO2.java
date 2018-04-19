package com.alltej.apps.cox;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.Arrays.asList;
import static java.util.stream.Collectors.summingInt;
import static java.util.stream.Collectors.toList;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Allan Tejano
 * 4/18/2018
 */
public class CxO2 {


    @Test public void sum_int_no_dups() {
        List<Integer> list = asList( 1, 2, 3, 4 );
        Map<Integer, Long> map = list.stream()
                .collect( Collectors.groupingBy( Integer::intValue, Collectors.counting() ) );
        List<Map.Entry<Integer, Long>> entries = map.entrySet().stream().filter( c -> c.getValue() == 1 )
                .collect( toList() );
        Integer sum = entries.stream().map( c -> c.getKey() ).collect( summingInt( Integer::intValue ) );
        assertEquals( 10, sum.intValue() );
    }

    @Test public void sum_int_with_dups() {
        List<Integer> list = asList( 1, 1, 2,2 , 3, 4 );
        Map<Integer, Long> map = list.stream()
                .collect( Collectors.groupingBy( Integer::intValue, Collectors.counting() ) );
        List<Map.Entry<Integer, Long>> entries = map.entrySet().stream().filter( c -> c.getValue() == 1 )
                .collect( toList() );
        Integer sum = entries.stream().map( c -> c.getKey() ).collect( summingInt( Integer::intValue ) );
        assertEquals( 7, sum.intValue() );
    }
}
