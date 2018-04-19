package com.alltej.apps.cox;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Arrays.asList;
import static java.util.stream.Collectors.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Allan Tejano
 * 4/18/2018
 */
public class CxO2_180419 {

    public int getSumOfNoDups( List<Integer> list ) {
        Map<Integer, Long> collect = list.stream().collect( Collectors.groupingBy( Integer::intValue, counting() ) );
        Integer integer = collect.entrySet().stream().filter( c -> c.getValue() == 1 ).map( Map.Entry::getKey )
                .collect( summingInt( Integer::intValue ) );
        return integer;
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
