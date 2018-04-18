package com.alltej.apps;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.Arrays.asList;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Allan Tejano
 * 4/17/2018
 */
public class StringWTheMostOccurence {
    @Test public void most_popular_name() {
        List<String> names = asList( "john", "john", "john", "john", "john", "john", "john", "john",
                "alex", "alex", "alex", "alex", "alex", "alex",
                "mike", "mike", "mike", "mike",
                "peter" );
        Map.Entry<String, Long> collect = names.stream().collect( groupingBy( String::toString, counting() ) )
                .entrySet().stream().collect( Collectors.collectingAndThen(
                        Collectors.reducing( ( n1, n2 ) -> n1.getValue() > n2.getValue() ? n1 : n2 ), Optional::get ) );
        assertEquals( "john", collect.getKey() );
        assertEquals( 8, collect.getValue().longValue());
    }
}
