package com.alltej.apps.hckrank.datastructures;

import java.util.*;

/**
 * @author atejano
 */
public class TowHashmap {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();

        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < t; i++) {
            String name = s.nextLine();
            int phone = s.nextInt();
            map.put(name, phone);
        }

        List<String> queries = new ArrayList<>();
        while (s.hasNext()) {
            queries.add(s.nextLine());
        }
//Write your code here
        for (String q : queries) {
            if (map.containsKey(q)) {
                System.out.println(q + "=" + map.get(q));
            } else {
                System.out.println("Not found");
            }
        }

    }
}
