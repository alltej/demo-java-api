package junit5;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

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
    public void testHeterogeneousMap() {
        Map heterogeneousMap = new HashMap();
        heterogeneousMap.put("Hmm", "Well");
        heterogeneousMap.put(1, 2);

        //Unsafe, will fail later when accessing 2nd entry
        //Doesn't check if map contains only Strings
        @SuppressWarnings("unchecked")
        Map<String, String> map = (Map<String, String>) heterogeneousMap;
        iterateMapKeysAsStrings(map);
    }

    @Test
    public void testHeterogeneousMap_withCastOf() {
        Map heterogeneousMap = new HashMap();
        heterogeneousMap.put("Hmm", "Well");
        heterogeneousMap.put(1, 2);

        //Unsafe, will fail later when accessing 2nd entry
        //Doesn't check if map contains only Strings
        @SuppressWarnings("unchecked")
        Map<String, String> map = (Map<String, String>) heterogeneousMap;
        iterateMapKeysAsStrings(map);
    }

    @Test
    public void testHomogeneousMap() {
        Map homogeneousMap = new HashMap();
        homogeneousMap.put("Hmm", "Well");
        homogeneousMap.put(1, 2);

        //Happens to be safe.  Does nothing to prove claim to be homogeneous.
        //Doesn't check if map contains only Strings
//        Map<String, String> simpleCastMap = (Map<String, String>) homogeneousMap;
//        iterateMapKeysAsStrings(simpleCastMap);

        //Succeeds properly after checking each item is an instance of a String
        Map<String, String> safeCastMap = castToMapOf(String.class, String.class, homogeneousMap);
        iterateMapKeysAsStrings(safeCastMap);
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
