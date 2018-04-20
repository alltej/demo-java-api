package junit5;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static java.util.Arrays.asList;
import static java.util.stream.Collectors.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Allan Tejano
 * 4/19/2018
 */
public class IntvwExercise_180419 {

    private static List<Integer> list = asList( 1, 2, 2, 3, 4, 1, 5, 6, 3, 4, 2,2, 3 );

    //1. find N that appeared the most number of times. (ex. N = 2; 2 appeared 4 times);
    //2. find sum of N's, where count of N equals 1. (ex. sum=5+6; 5 and 6 appared only 1 time)
    //3. create method that takes 2 parameters - list of integers and nTimes, that returns
    //             the first element that appeared nTimes.

    @Test public void one() {
        Map<Integer, Long> collect = list.stream().collect( groupingBy( Integer::intValue, counting() ) );
        Map.Entry<Integer, Long> entry = collect
                .entrySet().stream().collect(
                        collectingAndThen( reducing( ( e1, e2 ) -> e1.getValue() > e2.getValue() ? e1 : e2 ),
                                Optional::get ) );
        assertEquals( 2, entry.getKey().intValue() );
    }

    @Test public void two() {
        Map<Integer, Long> collect = list.stream().collect( groupingBy( Integer::intValue, counting() ) );
        Integer sum = collect.entrySet().stream().filter( c -> c.getValue() == 1 ).map( e -> e.getKey() )
                .collect( summingInt( Integer::intValue ) );
        assertEquals( 11, sum.intValue() );
    }

    @Test public void three() {
        assertEquals( Integer.valueOf( 2 ), findElement( list, 3 ) );
        assertEquals( Integer.valueOf( 2 ), findElement( list, 4 ) );
    }

    private Integer findElement( List<Integer> list, int n ) {
        Map<Integer, Integer> map = new HashMap<>();
        for ( int i : list ) {
            Integer merge = map.merge( i, 1, ( o, v ) -> o + v );
            if (merge==n)
                return i;
        }
        return null;
    }

}
