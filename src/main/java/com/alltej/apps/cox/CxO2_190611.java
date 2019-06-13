package com.alltej.apps.cox;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Arrays.asList;
import static java.util.stream.Collectors.counting;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author atejano
 */
public class CxO2_190611 {

    public int getSumOfNoDups( List<Integer> list ) {
        Integer sum = list.stream().collect(Collectors.groupingBy(Integer::intValue, counting()))
                .entrySet().stream().filter(k -> k.getValue() == 1)
                .map(kv -> kv.getKey()).collect(Collectors.summingInt(Integer::intValue));
        return sum;
    }

    public int getSumOfNoDups( int[] list ) {
        HashMap<Integer, Integer> set = new HashMap<>();
        int sum =0;
        for (int i : list) {
            Integer count = set.merge(i, 1, (o, n) -> o + n);
            if (count == 1) {
                sum+=i;
            } else if (count == 2) {
                sum -= i;
            }
        }
        return sum;
    }

    @Test public void sum_int_no_dups_arr() {
        int[] arr = {1, 2, 3, 4, 5};

        assertEquals( 15, getSumOfNoDups( arr  ));
    }

    @Test public void sum_int_with_dups_arr() {
//        List<Integer> list = asList( 1, 2, 2 , 3, 4, 4, 5 );

        int[] ints = {1, 2, 2, 3, 4, 4, 5};
        assertEquals( 9, getSumOfNoDups(ints) );
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
