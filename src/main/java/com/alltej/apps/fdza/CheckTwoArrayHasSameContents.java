package com.alltej.apps.fdza;

import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author atejano
 */
public class CheckTwoArrayHasSameContents {

    @Test
    public void test_sameContents_true() {
        String[] a = {"a", "b", "c", "d", "e"};
        String[] b = {"e", "d", "c", "b", "a"};
        assertTrue(sameContents(a, b));
    }

    @Test
    public void test_sameContents_case_insensitive_true() {
        String[] a = {"a", "b", "c", "d", "e"};
        String[] b = {"E", "d", "c", "b", "a"};
        assertTrue(sameContents(a, b));
    }

    @Test
    public void test_sameContents_with_duplicates_true() {
        String[] a = {"a", "b", "c", "d", "e", "a", "b", "b"};
        String[] b = {"b", "b", "a", "e", "d", "c", "b", "a"};
        assertTrue(sameContents(a, b));
    }

    @Test
    public void test_sameContents_false() {
        String[] a = {"a", "b", "c", "d", "e"};
        String[] b = {"a", "d", "c", "b", "a"};
        assertFalse(sameContents(a, b));
    }

    @Test
    public void test_not_same_length_false() {
        /***
         * it should fail on first test which is if length are not same
         */
        String[] a = {"a", "b", "c", "d", "e"};
        String[] b = {"a", "b"};
        assertFalse(sameContents(a, b));
    }

    static boolean sameContents(String[] a, String[] b) {
        if (a.length != b.length) return false;
        HashMap<String, Integer> set = new HashMap<>();

        for (String aa:a) {
            set.merge(aa, 1, (o, n) -> o + n);
        }
        for (String bb : b) {
            Integer count = set.merge(bb, 1, (o, n) -> (o - n));
            if (count != null && count < 0) {
                return false;
            }
        }
        return true;


    }
}
