package com.alltej.apps.cox;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.Arrays.asList;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author atejano
 */
public class CxO2_181102 {

    public int getSumOfNoDups( List<Integer> list ) {
        Map<Integer, Long> collect = list.stream().collect(Collectors.groupingBy(Integer::intValue, Collectors.counting()));
        Integer sum = collect.entrySet().stream().filter(e -> e.getValue() == 1).map(d -> d.getKey()).collect(Collectors.summingInt(Integer::intValue));
        return sum;
    }

    @Test
    public void sum_int_no_dups() {
        List<Integer> list = asList( 1, 2, 3, 4, 5 );

        assertEquals( 15, getSumOfNoDups( list ) );
    }

    @Test public void sum_int_with_dups() {
        List<Integer> list = asList( 1, 2, 2 , 3, 4, 4, 5 );

        assertEquals( 9, getSumOfNoDups( list ) );
    }
}
