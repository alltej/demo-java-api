package com.alltej.apps.codmttl;

/**
 * @author atejano
 */

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.Arrays.asList;
import static java.util.stream.Collectors.counting;
import static org.junit.jupiter.api.Assertions.assertEquals;
public class CodeMttlApp_190611 {
    /**
     * Given list of integers , find element n with max count
     * example:
     * list: [1, 3, 4, 4, 3, 2, 5, 6, 3, 4, 3]
     * n: 3
     */
    private int findElementWithMaxCount( List<Integer> list ) {
        return list.stream().collect(Collectors.groupingBy(Integer::intValue, counting()))
                .entrySet().stream().reduce((p, n)-> n.getValue()>p.getValue()?n:p)
                .get().getKey();
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
