package junit5;

import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.Arrays.asList;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Allan Tejano
 * 4/18/2018
 */
public class SortIntegers {

    @Test public void sort_ints() {

        List<Integer> sorted= asList( 4, 6, 8, 1, 5, 7, 9, 45, 34, 98, 34, 30, 78, 31, 28, 26 );
        Collections.sort(sorted);
        Collections.reverse( sorted );
        sorted.forEach( System.out::println );
    }

    @Test public void int_w_max_occurence() {

        List<Integer> ints = asList( 1,2,2,3,3,3,4,4,4,4,5,5,5,5,5,6,6,6,6,6,6,6 );
        Map<Integer, List<Integer>> collect = ints.stream()
                .collect( Collectors.groupingBy( Integer::intValue, Collectors.toList() ) );
        Map.Entry<Integer,  List<Integer>> entry = collect.entrySet().stream().collect( Collectors.collectingAndThen(
                Collectors.reducing( ( n1, n2 ) -> n1.getValue().size() > n2.getValue().size() ? n1 : n2 ),
                Optional::get ) );
        assertEquals( 6, entry.getKey().intValue() );
    }
}
