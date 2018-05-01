package com.alltej.apps.anagram;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Allan Tejano
 * 4/30/2018
 */
public final class AnagramAlgorithms {

    public static boolean isAnagrams1(String x, String y) {
        if (x.length() != y.length()) {
            return false;
        } else if (x.equals(y)) {
            return true;
        }

        Set<Character> anagramSet = new HashSet<>();
        for (int i = 0; i < x.length(); i++) {
            anagramSet.add(x.charAt(i));
            anagramSet.add(y.charAt(i));
        }

        return anagramSet.size() == x.length();
    }
}
