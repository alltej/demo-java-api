package com.alltej.apps.anagram;

import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author Allan Tejano
 * 4/30/2018
 */
public class AnagramTests_190611 {

    @Test public void hash() {
        assertTrue(isAnagrams_algo_1( "ABCDEFG", "DEFGABC" ));
        assertFalse(isAnagrams_algo_1( "ABCDEFG", "DDFGABC" ));
        assertTrue(isAnagrams_algo_1( "ABCDEFGHIJKLMNOPQRSTUVWXYZ", "Zyxwvutsrqponmlkjihgfedcba" ));
        assertTrue(isAnagrams_algo_1( "ABCDEFG123456", "A1B2c3d4E5f6g" ));
    }


    public static boolean isAnagrams_algo_1(String x, String y) {
        //code here
        if (x.length() != y.length()) return false;
        if (x.equalsIgnoreCase(y)) return true;

        HashMap<Character, Integer> set = new HashMap<>();

        char[] xchars = x.toLowerCase().toCharArray();
        for (char xchar : xchars) {
            set.merge(xchar, 1, (o, n) -> o + n);
        }
        char[] ychars = y.toLowerCase().toCharArray();
        for (char ychar : ychars) {
            Integer count = set.merge(ychar, 1, (o, n) -> o - 1);
            if (count < 0) {
                return false;
            }

        }

        return true;
    }
}
