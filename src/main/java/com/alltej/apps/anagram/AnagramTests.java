package com.alltej.apps.anagram;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author Allan Tejano
 * 4/30/2018
 */
public class AnagramTests {

    @Test public void hash() {
        assertTrue(isAnagrams_algo_1( "ABCDEFG", "DEFGABC" ));
        assertFalse(isAnagrams_algo_1( "ABCDEFG", "DDFGABC" ));
        //assertFalse(isAnagrams_algo_1( "ABCDEFG", "DDFGABC" ));
        assertTrue(isAnagrams_algo_1( "ABCDEFGHIJKLMNOPQRSTUVWXYZ", "Zyxwvutsrqponmlkjihgfedcba" ));
        assertTrue(isAnagrams_algo_1( "ABCDEFG123456", "A1B2c3d4E5f6g" ));
    }


    public static boolean isAnagrams_algo_1(String x, String y) {
        x = x.toLowerCase();
        y = y.toLowerCase();
        if (x.length() != y.length()) {
            return false;
        } else if (x.equals(y)) {
            return true;
        }

        Map<Character, Integer> anagramSetX = new HashMap<>();
        //Set<Character> anagramSetY = new HashSet<>();
        char[] xchars = x.toCharArray();
        for (char a: xchars) {
            anagramSetX.merge( a, 1, ( o, n ) -> o + n );
        }
        char[] ychars = y.toCharArray();
        for (char b: ychars) {
            Integer count = anagramSetX.merge( b, 1, (o, n) -> o-n );
            if (count != null && count < 0) {
                return false;
            }
        }
        return true;
    }
}
