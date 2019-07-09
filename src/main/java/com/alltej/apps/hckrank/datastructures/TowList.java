package com.alltej.apps.hckrank.datastructures;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author atejano
 */

//Input:
//5
//12 0 1 78 12
//2
//Insert
//5 23
//Delete
//0

//Output:

//0 1 78 12 23

public class TowList {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int l = s.nextInt();
        System.out.println("len of input: " + l);
        List<Integer> ints = new ArrayList<>();

        for (int i = 0; i < l; i++) {
            int e = s.nextInt();
            System.out.println(e);
            ints.add(e);
        }
        System.out.println("ints.size: " + ints.size());
        int n = s.nextInt();
        System.out.println("num queries: " + n);
        for (int i = 0; i < n; i++) {
            String cmd = s.next();
            System.out.println("cmd: " + cmd);
            if (cmd.equalsIgnoreCase("insert")) {
                int pos = s.nextInt();
                int val = s.nextInt();
                ints.add(pos, val);
            } else if (cmd.equalsIgnoreCase("delete")) {
                ints.remove(s.nextInt());
            }
        }

        for (int x:ints) {
            System.out.print(x + " ");
        }
    }


}

