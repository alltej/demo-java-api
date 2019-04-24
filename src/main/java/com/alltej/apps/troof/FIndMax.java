package com.alltej.apps.troof;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author atejano
 */
public class FIndMax {

    static int[] withNegative = {-6, -4, -2, 0, 2, 4, 6, 8, 10, 12, 14};
    static int[] allNegatives = {-9, -7, -5,-4,-3,-2,-1};
    static int[] noNegative = {11,31,21,41,51,71,61,81,91,111,121,1,2,3,4,5,6};

    @Test
    public void findWithMixNeg() {

        assertEquals(14, getMax(withNegative));
        assertEquals(12, getMax2(withNegative));
    }

    @Test
    public void findFromNoNeg() {

        assertEquals(111, getMax2(noNegative));
    }

    @Test
    public void findFromAllNeg() {

        assertEquals(-1, getMax(allNegatives));
        assertEquals(-2, getMax2(allNegatives));
    }

    private int getMax(int[] ints) {
        int max = Integer.MIN_VALUE;
        for (int i : ints) {
            if (i > max) {
                max = i;
            }
        }
        return max;
    }

    private int getMax2(int[] ints) {
        int max = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;
        for (int i : ints) {
            if (i > max) {
                max2 = max;
                max = i;
            }
        }
        return max2;
    }


}
