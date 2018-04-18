package junit5.datastructures;

import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Allan Tejano
 * 4/17/2018
 */
public class TreeMapTest {

    @Test public void givenTreeMap_w_int_keys_returns_keysets_in_order() {
        TreeMap<Integer, String> map = new TreeMap<>();
        map.put( 8, "eight" );
        map.put( 3, "three" );
        map.put( 2, "two" );
        map.put( 6, "six" );
        map.put( 5, "five" );
        map.put( 7, "seven" );
        assertEquals( "[2, 3, 5, 6, 7, 8]", map.keySet().toString() );
    }

    @Test public void givenTreeMap_w_string_keys_returns_keysets_in_order() {
        TreeMap<String, String> map = new TreeMap<>();
        map.put( "e", "eight" );
        map.put( "th", "three" );
        map.put( "tw", "two" );
        map.put( "si", "six" );
        map.put( "f", "five" );
        map.put( "se", "seven" );
        assertEquals( "[e, f, se, si, th, tw]", map.keySet().toString() );
    }


    @Test public void givenTreeMap_w_comparator_constructor_returns_keysets_in_order() {
        TreeMap<Integer, String> map = new TreeMap<>( Comparator.reverseOrder());
        map.put( 8, "eight" );
        map.put( 3, "three" );
        map.put( 2, "two" );
        map.put( 6, "six" );
        map.put( 5, "five" );
        map.put( 7, "seven" );
        assertEquals( "[8, 7, 6, 5, 3, 2]", map.keySet().toString() );
    }

    @Test public void treeMap_highestKey_lowestKey_features() {
        TreeMap<Integer, String> map = new TreeMap<>();
        map.put( 8, "eight" );
        map.put( 1, "one" );
        map.put( 3, "three" );
        map.put( 2, "two" );
        map.put( 6, "six" );
        map.put( 4, "four" );
        map.put( 5, "five" );
        map.put( 7, "seven" );

        assertEquals( 8, map.lastKey().intValue());;
        assertEquals( 1, map.firstKey().intValue());;
        Set<Integer> keysLT3 = map.headMap( 3 ).keySet();
        assertEquals( "[1, 2]", keysLT3.toString());

        Set<Integer> keysEqOrGreaterThan2 = map.tailMap( 3 ).keySet();
        assertEquals( "[3, 4, 5, 6, 7, 8]", keysEqOrGreaterThan2.toString());
    }
}
