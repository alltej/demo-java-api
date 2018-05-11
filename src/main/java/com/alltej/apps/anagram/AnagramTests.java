package com.alltej.apps.anagram;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
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

        Set<Character> anagramSetX = new HashSet<>();
        Set<Character> anagramSetY = new HashSet<>();
        for (int i = 0; i < x.length(); i++) {
            anagramSetX.add(x.charAt(i));
            anagramSetY.add(y.charAt(i));
        }

        return anagramSetX.size() == anagramSetY.size() ;
    }
}
