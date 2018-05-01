package com.alltej.apps.anagram;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author Allan Tejano
 * 4/30/2018
 */
public class AnagramTests {

    @Test public void hash() {
        assertTrue(AnagramAlgorithms.isAnagrams1( "ABCDEFG", "DEFGABC" ));
        assertTrue(AnagramAlgorithms.isAnagrams1( "ABCDEFG", "DDFGABC" ));
    }
}
