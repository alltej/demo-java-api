package com.alltej.apps.cox;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.Arrays.asList;
import static java.util.stream.Collectors.summingInt;
import static java.util.stream.Collectors.toList;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Allan Tejano
 * 5/2/2018
 */
public class CxO2_180502 {
    public int getSumOfNoDups( List<Integer> list ) {

        Map<Integer, Long> map = list.stream()
                .collect( Collectors.groupingBy( Integer::intValue, Collectors.counting() ) );
        Integer sum = map.entrySet().stream().filter( es -> es.getValue() == 1 ).map( n -> n.getKey() )
                .collect( summingInt( Integer::intValue ) );
        return sum;
    }

    public static int getSumOfNoDupsUsingStream(int[] arr ) {
        List<Integer> list = Arrays.stream( arr ).boxed().collect( toList() );
        Map<Integer, Long> map = list.stream()
                .collect( Collectors.groupingBy( Integer::intValue, Collectors.counting() ) );
        Integer sum = map.entrySet().stream().filter( es -> es.getValue() == 1 ).map( n -> n.getKey() )
                .collect( summingInt( Integer::intValue ) );
        return sum;
    }

    public static int getSumOfNoDupsUsingStream(List<Integer> list ) {
        //List<Integer> list = Arrays.stream( arr ).boxed().collect( toList() );
        Map<Integer, Long> map = list.stream()
                .collect( Collectors.groupingBy( Integer::intValue, Collectors.counting() ) );
        Integer sum = map.entrySet().stream().filter( es -> es.getValue() == 1 ).map( n -> n.getKey() )
                .collect( summingInt( Integer::intValue ) );
        return sum;
    }

    public static int getSumOfNoDups( int[] arr ) {

        HashMap<Integer, Integer> map = new HashMap<>();
        for(int x = 0; x<arr.length; x++) {
            map.merge( arr[x], 1, ( o, n ) -> o + n );
        }
//        int sum = 0;
//        for ( Map.Entry<Integer, Integer> e : map.entrySet() ) {
//            if (e.getValue() == 1) {
//                sum += e.getKey();
//            }
//        }
        int sum  = map.entrySet().stream().filter( e -> e.getValue() == 1 ).collect( summingInt( Map.Entry::getKey) );
        return sum;
    }

    @Test public void sum_int_no_dups() {
        int[] arr = {1, 2, 3, 4, 5 };

        String[] ss = { "A", "B", "c", "D", "e" };
        List<String> strings = asList( ss );

        List<Integer> list = asList( 1, 2, 3, 4, 5 );

        assertEquals( 15, getSumOfNoDups( list ) );
    }

    @Test public void sum_int_with_dups() {
        List<Integer> list = asList( 1, 2, 2 , 3, 4, 4, 5 );

        assertEquals( 9, getSumOfNoDups( list ) );
    }


    @Test public void sum_int_with_dups_using_stream() {
        List<Integer> list = asList( 1, 2, 2 , 3, 4, 4, 5 );

        assertEquals( 9, getSumOfNoDups( list ) );
    }

    @Test public void sum_int_with_dups_using_map() {
        int[] arr = {1, 2, 2 , 3, 4, 4, 5,6,7,8,9,11,22,33,44,55,66,77,88,99,21,22,23,24,25,26,27,28,29,31,32,33,34,35,36,37,38,39,40,41,42,43,44,45,46,47,48,48,49,50,98,97,969,59,49,3,92,
                    23,24,56,54,34,33,44,55,66,77,23,45,54,32,31,31,3,2,33,34,78,79,89,90,32,45,41,4,2,42,43,44,45,46,47,48,49,1,22,33,44,55,66,77,88,99,21,22, 100,111,222,33,444,555,666,23,
                    34,56,7,8,23,111,222,555,444,666,1, 2, 2 , 3, 4, 4, 5,6,7,8,9,11,22,33,44,55,66,77,88,99,21,22,23,24,25,26,27,28,29,31,32,33,34,35,36,37,38,39,40,41,42,43,44,45,46,47,48,48,49,50,98,97,969,59,49,3,92,
                23,24,56,54,34,33,44,55,66,77,23,45,54,32,31,31,3,2,33,34,78,79,89,90,32,45,41,4,2,42,43,44,45,46,47,48,49,1,22,33,44,55,66,77,88,99,21,22, 100,111,222,33,444,555,666,23,
                34,56,7,8,23,111,222,555,444,666, 771};

        //assertEquals( 9, getSumOfNoDups( arr ) );
        System.out.println(getSumOfNoDups( arr ));
    }

//    public static void main( String[] args ) throws InterruptedException {
//        int[] arr = {1, 2, 2 , 3, 4, 4, 5,6,7,8,9,11,22,33,44,55,66,77,88,99,21,22,23,24,25,26,27,28,29,31,32,33,34,35,36,37,38,39,40,41,42,43,44,45,46,47,48,48,49,50,98,97,969,59,49,3,92,
//                23,24,56,54,34,33,44,55,66,77,23,45,54,32,31,31,3,2,33,34,78,79,89,90,32,45,41,4,2,42,43,44,45,46,47,48,49,1,22,33,44,55,66,77,88,99,21,22, 100,111,222,33,444,555,666,23,
//                34,56,7,8,23,111,222,555,444,666,1, 2, 2 , 3, 4, 4, 5,6,7,8,9,11,22,33,44,55,66,77,88,99,21,22,23,24,25,26,27,28,29,31,32,33,34,35,36,37,38,39,40,41,42,43,44,45,46,47,48,48,49,50,98,97,969,59,49,3,92,
//                23,24,56,54,34,33,44,55,66,77,23,45,54,32,31,31,3,2,33,34,78,79,89,90,32,45,41,4,2,42,43,44,45,46,47,48,49,1,22,33,44,55,66,77,88,99,21,22, 100,111,222,33,444,555,666,23,
//                34,56,7,8,23,111,222,555,444,666, 771};
//
//        Thread.sleep(1000);
//        System.out.println("runUsingStream");
//        runUsingStream(arr);
//        System.out.println("-----------------------------");
//        System.out.println("runUsingMapAndLoopForSum and stream to get SUM");
//        runUsingMapAndLoopForSum(arr);
//        Thread.sleep(1000);
//        System.out.println("-----------------------------");
//        System.out.println("runUsingMapAndStreamForSum");
//        runUsingMapAndStreamForSum(arr);
//        Thread.sleep(1000);
//        System.out.println("-----------------------------");
//    }




}
