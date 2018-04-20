package junit5.datastructures;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.reducing;
import static java.util.stream.Collectors.toMap;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Allan Tejano
 * 4/20/2018
 */
public class HashMapTests_180420 {
    private HashMap<Integer, String> unsorted = new HashMap<>();

    @BeforeEach
    private void setup() {
        unsorted.put( 9, "nine" );
        unsorted.put( 5, "five" );
        unsorted.put( 7, "seven" );
        unsorted.put( 2, "two" );
        unsorted.put( 8, "eight" );
        unsorted.put( 1, "one" );
        unsorted.put( 3, "four" );

    }

    @Test public void sort_and_reverse_map_by_key_using_treemap() {
        System.out.println("sort_and_reverse_map_by_key_using_treemap");

        System.out.println("original");
        System.out.println(unsorted);

        System.out.println("sorted");
        TreeMap<Integer, String> sorted = new TreeMap<>( unsorted );
        System.out.println(sorted);

        System.out.println("reversed");
        TreeMap<Integer, String> sortedR = new TreeMap<>( Comparator.reverseOrder());
        sortedR.putAll( unsorted );
        System.out.println(sortedR);
    }

    @Test public void sort_and_reverse_map_by_key_using_linkedHashMap() {
        System.out.println("sort_and_reverse_map_by_key_using_linkedHashMap");
        Map<Integer, String> sorted = unsorted.entrySet().stream()
                .sorted( ( x, y ) -> x.getKey().compareTo( y.getKey() ) )
                .collect( toMap( Map.Entry::getKey, Map.Entry::getValue, ( o, n ) -> n, LinkedHashMap::new ) );

        System.out.println("sorted");
        System.out.println(sorted);

        Map<Integer, String> reversed = unsorted.entrySet().stream()
                .sorted( (x,y)->y.getKey().compareTo(x.getKey()) )
                .collect( toMap( Map.Entry::getKey, Map.Entry::getValue, (o, n) -> o, LinkedHashMap::new ) );
        reversed.putAll( unsorted );
        System.out.println("reversed");
        System.out.println(reversed);

    }

    @Test public void find_max_value() {
        Map<String, Integer> map = new HashMap<>();
        map.put( "A", 4 );
        map.put( "B", 5 );
        map.put( "C", 6 );
        map.put( "D", 7 );
        map.put( "E", 8 );

        Map.Entry<String, Integer> maxEntry = map.entrySet().stream().collect( Collectors
                .collectingAndThen( reducing( ( e1, e2 ) -> e1.getValue() > e2.getValue() ? e1 : e2 ),
                        Optional::get ) );

        assertEquals( 8, maxEntry.getValue().intValue() );
    }
}
