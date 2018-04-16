package junit5;


import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.Arrays.asList;
import static java.util.Arrays.sort;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Allan Tejano
 * 4/15/2018
 */
public class MapMergeTest {

    @Test public void merge_map() {
        Map<String, Integer> visits = new HashMap<>();

        addVisitFor( "A",visits );
        addVisitFor( "B",visits );
        addVisitFor( "A",visits );
        addVisitFor( "A" ,visits);
        addVisitFor( "B",visits );

        assertEquals(Integer.valueOf( 3 ), visits.get( "A" ));
    }

    //use functional programming
    private void addVisitFor( String b, Map<String, Integer> visits ) {
        visits.merge( b, 1, ( o, n ) -> o + n );
    }

    private void addVisitFor_old( String b, Map<String, Integer> visits ) {
        if (!visits.containsKey( b )) {
            visits.put( b, 0 );
        }
        visits.put( b, visits.get( b ) + 1 );
    }


    @Test public void max_count_in_list() {
        List<Integer> list = asList( 2, 4, 6, 2, 5, 2, 4, 2, 5, 7, 2, 9, 3, 5, 2 );
        Map<Integer, Long> collect = list.stream()
                .collect( Collectors.groupingBy( Integer::valueOf, Collectors.counting() ) );
        Long aLong = collect.entrySet().stream().map( e -> e.getValue() ).collect(
                Collectors.collectingAndThen( Collectors.reducing( ( e1, e2 ) -> e1 > e2 ? e1 : e2 ), Optional::get ) );
        Map.Entry<Integer, Long> entry = collect.entrySet().stream().collect( Collectors
                .collectingAndThen( Collectors.reducing( ( e1, e2 ) -> e1.getValue() > e2.getValue() ? e1 : e2 ),
                        Optional::get ) );
        System.out.println(entry);
        assertEquals( Integer.valueOf( 2 ), entry.getKey() );
        assertEquals( Integer.valueOf( 6 ), entry.getValue() );

    }
}
