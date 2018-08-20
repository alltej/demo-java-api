package com.alltej.apps.anagram;

import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Anagram_180702 {

    @Test
    public void hash() {
        assertTrue(isAnagrams_algo_1( "ABCDEFG", "DEFGABC" ));
        assertFalse(isAnagrams_algo_1( "ABCDEFG", "DDFGABC" ));
        assertTrue(isAnagrams_algo_1( "ABCDEFGHIJKLMNOPQRSTUVWXYZ", "Zyxwvutsrqponmlkjihgfedcba" ));
        assertTrue(isAnagrams_algo_1( "ABCDEFG123456", "A1B2c3d4E5f6g" ));
    }


    public static boolean isAnagrams_algo_1(String x, String y) {
        //code here
        if (x.length()!=y.length()) return false;
        if (x.equalsIgnoreCase(y)) {
            return  true;
        }

        HashMap<Character, Integer> set = new HashMap<>();

        char[] xchars = x.toLowerCase().toCharArray();
        for (char a: xchars) {
            set.merge(a, 1, (o, n) -> o+n);
        }
        char[] ychars = y.toLowerCase().toCharArray();
        for (char b : ychars) {
            Integer count = set.merge(b, 1, (o, n) -> (o - n));
            if (count != null && count < 0) {
                return false;
            }

        }
        return true;
    }


}
