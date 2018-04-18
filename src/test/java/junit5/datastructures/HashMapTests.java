package junit5.datastructures;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author Allan Tejano
 * 4/18/2018
 */
public class HashMapTests {

    @Test public void sort_unsorted_map_by_key() {
        HashMap<Integer, String> unsorted = new HashMap<>();
        unsorted.put( 9, "nine" );
        unsorted.put( 5, "five" );
        unsorted.put( 7, "seven" );
        unsorted.put( 2, "two" );
        unsorted.put( 8, "eight" );
        unsorted.put( 1, "one" );
        unsorted.put( 3, "four" );

        Map<Integer, String> sorted = unsorted.entrySet().stream().sorted( Map.Entry.comparingByKey() )
                .collect( Collectors.toMap( Map.Entry::getKey, Map.Entry::getValue ) );
        sorted.entrySet().stream().forEach( s -> {
            System.out.println( s.getKey() );} );
    }
}
