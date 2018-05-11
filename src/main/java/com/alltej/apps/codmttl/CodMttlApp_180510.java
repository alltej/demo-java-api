package com.alltej.apps.codmttl;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import static java.util.Arrays.asList;
import static java.util.stream.Collectors.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Allan Tejano
 * 5/10/2018
 */
public class CodMttlApp_180510 {
    /**
     * Given list of integers , find element n with max count
     * example:
     * list: [1, 3, 4, 4, 3, 2, 5, 6, 3, 4, 3]
     * n: 3
     */
    private int findElementWithMaxCount( List<Integer> list ) {
        Map<Integer, Long> map = list.stream().collect( groupingBy( Integer::intValue, counting() ) );
        Map.Entry<Integer, Long> entry = map.entrySet().stream().collect(
                collectingAndThen( reducing( ( e1, e2 ) -> e1.getValue() > e2.getValue() ? e1 : e2 ), Optional::get ) );
        return entry.getKey();
    }

    @Test public void run_example() {
        int n = findElementWithMaxCount( asList( 1, 3, 4, 4, 3, 2, 5, 6, 3, 4, 3 ) );
        assertEquals( 3, n );
    }

    @Test public void another_example() {
        int n = findElementWithMaxCount( asList( 1,1,1,1,1,11,1,1,1,1,12,2,2,2,2,2,3,3,3,3,3,1,1,1,1,1) );
        assertEquals( 1, n );
    }
}
