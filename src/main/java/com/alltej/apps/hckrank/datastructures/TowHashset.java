package com.alltej.apps.hckrank.datastructures;

import java.util.HashSet;
import java.util.Scanner;

/**
 * @author atejano
 */
public class TowHashset {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        String [] pair_left = new String[t];
        String [] pair_right = new String[t];

        for (int i = 0; i < t; i++) {
            pair_left[i] = s.next();
            pair_right[i] = s.next();
        }

//Write your code here
        HashSet<String> strings = new HashSet<>();
        for (int i = 0; i < t; i++) {
            String pairs = pair_left[i] + ":" + pair_right[i];
            strings.add(pairs);
            System.out.println(strings.size());
        }

    }
}
