package com.alltej.apps.cox;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.Arrays.asList;
import static java.util.stream.Collectors.summingInt;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Allan Tejano
 * 5/2/2018
 */
public class CxO2_180502 {
    public int getSumOfNoDups( List<Integer> list ) {

        Map<Integer, Long> map = list.stream()
                .collect( Collectors.groupingBy( Integer::intValue, Collectors.counting() ) );
        Integer sum = map.entrySet().stream().filter( es -> es.getValue() == 1 ).map( n -> n.getKey() )
                .collect( summingInt( Integer::intValue ) );
        return sum;
    }

    @Test public void sum_int_no_dups() {
        List<Integer> list = asList( 1, 2, 3, 4, 5 );

        assertEquals( 15, getSumOfNoDups( list ) );
    }

    @Test public void sum_int_with_dups() {
        List<Integer> list = asList( 1, 2, 2 , 3, 4, 4, 5 );

        assertEquals( 9, getSumOfNoDups( list ) );
    }
}
