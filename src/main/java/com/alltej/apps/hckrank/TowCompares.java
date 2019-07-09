package com.alltej.apps.hckrank;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author atejano
 */


public class TowCompares {
//    /*dfsdfsdfdsfs/* **//*** */*/
    public static void main(String[] args) {
        String[] cities = {"B", "P", "SF", "NYC"};
        Mysort ms = new Mysort();
        Arrays.sort(cities, ms);
        System.out.println(Arrays.binarySearch(cities, "NYC"));
    }

    static class Mysort implements Comparator<String> {

        public int compare(String o1, String o2) {
            return o2.compareTo(o1);
        }

    }
}
