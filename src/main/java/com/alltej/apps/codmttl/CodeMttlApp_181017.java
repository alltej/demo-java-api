package com.alltej.apps.codmttl;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.Arrays.asList;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.reducing;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author atejano
 */
public class CodeMttlApp_181017 {
    /**
     * Given list of integers , find element n with max count
     * example:
     * list: [1, 3, 4, 4, 3, 2, 5, 6, 3, 4, 3]
     * n: 3
     */
    private int findElementWithMaxCount( List<Integer> list ) {
        Map<Integer, Long> intCount = list.stream().collect(Collectors.groupingBy(Integer::intValue, counting()));
        Optional<Map.Entry<Integer, Long>> intWMax = intCount.entrySet().stream()
                .collect(reducing((e1, e2) -> e1.getValue() > e2.getValue() ? e1 : e2));
        return intWMax.get().getKey();
    }

    @Test
    public void run_example() {
        int n = findElementWithMaxCount( asList( 1, 3, 4, 4, 3, 2, 5, 6, 3, 4, 3 ) );
        assertEquals( 3, n );
    }

    @Test public void another_example() {
        int n = findElementWithMaxCount( asList( 1,1,1,1,1,11,1,1,1,1,12,2,2,2,2,2,3,3,3,3,3,1,1,1,1,1) );
        assertEquals( 1, n );
    }

    @Test
    public void findMaxNumberInList( ) {
        List<Integer> list = asList( 1, 3, 4, 4,99, 3, 2, 5, 6, 3, 4, 3, 5,6,7,8,9, 77);
        Optional<Integer> max = list.stream().collect(Collectors.reducing((e1, e2) -> e1 > e2 ? e1 : e2));
        assertEquals(99, max.get().intValue());
        Optional<Integer> max2 = list.stream().reduce(Integer::max);
        assertEquals(99, max2.get().intValue());
    }
}
