package com.alltej.apps.fdza;

import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.function.Function;

import static java.util.Arrays.asList;
import static java.util.stream.Collectors.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author atejano
 */
public class ParseAndSummarizeListOfLists {


    private static List<String> data = asList("key1=value111,key2=value12,key3=13,key4=1.4",
            "key1=value111,key2=value12,key3=13,key4=1.4",
            "key1=value111,key2=value12,key3=13,key4=1.4",
            "key1=value333,key2=value33,key3=33,key4=3.4",
            "key1=value333,key2=value12,key3=13,key4=1.5",
            "key1=value333,key2=value14,key3=13,key4=1.5");
    @Test
    public void test_basic() {

        List<List<String>> res = get_res(data);
        //[key1, value111, value333]
        //[key2, value12]
        //[key3, 13]
        //[key4, 1.4]

        assertEquals("key1",res.get(0).get(0));
        assertEquals("value111",res.get(0).get(1) );
        assertEquals("value333",res.get(0).get(2) );
        assertEquals("value12",res.get(1).get(1) );

    }

    public static void main(String[] args) {

        List<List<String>> res = get_res(data);

        res.forEach(k -> {
            System.out.println(k);
        });
    }

    public static List<List<String>> get_res(List<String> data) {
        List<List<String[]>> collect = data.stream().map(l -> l.split(","))
                .map(m -> Arrays.stream(m).map(n -> n.split("=")).collect(toList()))
                .collect(toList());

        HashMap<String, List<String>> keyList = new HashMap<>();

        collect.forEach(k -> {
            k.forEach(v -> {
                if (keyList.get(v[0]) == null) {
                    keyList.put(v[0], new ArrayList<>());
                }
                keyList.get(v[0]).add(v[1]);
            });
        });

        List<List<String>> lists = new ArrayList<>();
        keyList.entrySet().forEach(k -> {
            Map<String, Long> maxColl = k.getValue().stream().collect(groupingBy(Function.identity(), counting()));
            Long maxCount = maxColl.entrySet().stream().max(Map.Entry.comparingByValue()).get().getValue();
            //System.out.println(maxCount);
            List<String> keyValues = maxColl.entrySet().stream().filter(p -> p.getValue() == maxCount).map(r -> r.getKey()).collect(toList());
            keyValues.add(0, k.getKey());
            lists.add(keyValues);
        });

        return lists;

    }
}
