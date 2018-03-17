package junit5;

import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.Arrays.asList;
import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Allan Tejano
 * 3/5/2018
 */
public class MapTest {

    private static void iterateMapKeysAsStrings(Map<String, ?> map) {
        for (String key : map.keySet()) {
            // nothing to do, invalid cast will be triggered for wrong type
        }
    }

    @Test
    public void testHeterogeneousMap_cast_throws_excpetion() {
        Map heterogeneousMap = new HashMap();
        heterogeneousMap.put("Hmm", "Well");
        heterogeneousMap.put(1, 2);

        //Unsafe, will fail later when accessing 2nd entry
        //Doesn't check if map contains only Strings
        @SuppressWarnings("unchecked")
        Map<String, String> map = (Map<String, String>) heterogeneousMap;
        assertThrows(ClassCastException.class, () -> {
            iterateMapKeysAsStrings(map);
        });
    }

    //TODO
    @Test
    public void testHomogeneousMap_throws_exception() {
        Map homogeneousMap = new HashMap();
        homogeneousMap.put("Hmm", "Well");
        homogeneousMap.put(1, 2);

        //Happens to be safe.  Does nothing to prove claim to be homogeneous.
        //Doesn't check if map contains only Strings
//        Map<String, String> simpleCastMap = (Map<String, String>) homogeneousMap;
//        iterateMapKeysAsStrings(simpleCastMap);

        //Succeeds properly after checking each item is an instance of a String
        assertThrows( ClassCastException.class, () ->{
            castToMapOf(String.class, String.class, homogeneousMap);

        } );

        assertThrows(ClassCastException.class, () -> {
            Map<String, String> safeCastMap = castToMapOf(String.class, String.class, homogeneousMap);
            iterateMapKeysAsStrings(safeCastMap);
        });

    }

    @Test public void map_null_key_does_not_throw_exception() {
        Map<Integer, String> map = new HashMap<>(  );
        map.put( null, "null" );
        map.put( 1, "1_b" );
        assertEquals(2, map.entrySet().size());
        map.entrySet().stream().forEach( e -> {
            System.out.println(e.getKey() + "::" + e.getValue());
        } );
    }

    @Test public void map_duplicate_key_does_not_throw_exception() {
        Map<Integer, String> map = new HashMap<>(  );
        map.put( 1, "1_a" );
        map.put( 1, "1_b" );
        assertEquals(1, map.entrySet().size());
        map.entrySet().stream().forEach( e -> {
            System.out.println(e.getKey() + "::" + e.getValue());
        } );
    }

    @Test public void map_duplicate_key_replaced_old_key_value() {
        Map<Integer, String> map = new HashMap<>(  );
        map.put( 1, "1a" );
        map.put( 1, "1b" );
        assertEquals("1b", map.entrySet().stream().filter( e -> e.getKey().equals( 1 ) ).map( e -> e.getValue() ).findFirst().get());
        map.entrySet().stream().forEach( e -> {
            System.out.println(e.getKey() + "::" + e.getValue());
        } );
    }


    @Test public void map_null_key_stream_filter_by_null_key_throws_exception() {
        Map<Integer, String> map = new HashMap<>(  );
        map.put( null, "null" );
        map.put( 1, "1_a" );

        try {
            Optional<Integer> s = map.entrySet().stream()
                    .map( e -> e.getKey() )
                    .filter( Objects::isNull).findFirst();
            fail( "should throw exception" );
        } catch ( Exception e ) {
        }
    }

    @Test public void list_remove_duplicate_by_stream_using_distinct() {
        List<String> list = asList( "AA", "BB", "CC", "AA", "DD", "BB", "EE", "CC" );
        List<String> distinc = list.stream().distinct().collect( Collectors.toList() );
        assertEquals( 5, distinc.size() );
        distinc.forEach( System.out::println );

    }


    /** Check all contained items are claimed types and fail early if they aren't */
    public static <K, V> Map<K, V> castToMapOf(
            Class<K> clazzK,
            Class<V> clazzV,
            Map<?, ?> map) {

        for ( Map.Entry<?, ?> e: map.entrySet() ) {
            checkCast( clazzK, e.getKey() );
            checkCast( clazzV, e.getValue() );
        }

        @SuppressWarnings("unchecked")
        Map<K, V> result = (Map<K, V>) map;
        return result;
    }

    private static  String LS = "ALTJEJ";
    /** Check if cast would work */
    public static <T> void checkCast(Class<T> clazz, Object obj) {
        if ( !clazz.isInstance(obj) ) {
            throw new ClassCastException(
                    LS + "Expected: " + clazz.getName() +
                            LS + "Was:      " + obj.getClass().getName() +
                            LS + "Value:    " + obj
            );
        }
    }
}
