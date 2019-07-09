package com.alltej.apps.hckrank.datastructures;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Scanner;

/**
 * @author atejano
 */
public class TowDequeue {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Deque<Integer> dequeu = new ArrayDeque<>();
        int n = in.nextInt();
        int m = in.nextInt();

        HashSet<Integer> set = new HashSet<>();
        int max = 0;

        for (int i = 0; i < n; i++) {
            int num = in.nextInt();
            dequeu.add(num);
            set.add(num);

            if( dequeu.size() == m ){
                max = set.size() > max ? set.size() : max;
                int tmp = dequeu.remove();
                if( !dequeu.contains(tmp) )
                    set.remove(tmp);
            }
        }
        System.out.println(max);
        in.close();
    }
}