package com.alltej.apps.cox;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.Arrays.asList;
import static java.util.stream.Collectors.summingInt;
import static java.util.stream.Collectors.toList;

/**
 * @author Allan Tejano
 * 5/4/2018
 */
public class DupAlgorithmPerfCompare {

//    JMH Benchmark Modes
//    JMH can run your benchmarks in different modes. The benchmark mode tells JMH what you want to measure. JMH offer these benchmark modes:
//
//    Throughput	Measures the number of operations per second, meaning the number of times per second your benchmark method could be executed.
//    Average Time	Measures the average time it takes for the benchmark method to execute (a single execution).
//    Sample Time	Measures how long time it takes for the benchmark method to execute, including max, min time etc.
//    Single Shot Time	Measures how long time a single benchmark method execution takes to run. This is good to test how it performs under a cold start (no JVM warm up).
//    All	Measures all of the above.

//    public static void main(String[] args) throws RunnerException {
//        Options opt = new OptionsBuilder()
//                .include(DupAlgorithmPerfCompare.class.getSimpleName())
//                .warmupIterations(1)// number of times the warmup iteration should take place
//                .measurementIterations(1)//number of times the actual iteration should take place
//                .forks(1)
//                .shouldDoGC(true)
//                .build();
//
//
//        new Runner(opt).run();
//    }

    public static void main( String[] args ) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(Benchmark.class.getSimpleName())
                .forks(1)
                .build();
        new Runner(opt).run();
    }

//    public void measureName() {
//        List<Long> times = new ArrayList<>();
//
//        List<Integer> list = asList(1, 2, 2 , 3, 4, 4, 5,6,7,8,9,11,22,33,44,55,66,77,88,99,21,22,23,24,25,26,27,28,29,31,32,33,34,35,36,37,38,39,40,41,42,43,44,45,46,47,48,48,49,50,98,97,969,59,49,3,92,
//                23,24,56,54,34,33,44,55,66,77,23,45,54,32,31,31,3,2,33,34,78,79,89,90,32,45,41,4,2,42,43,44,45,46,47,48,49,1,22,33,44,55,66,77,88,99,21,22, 100,111,222,33,444,555,666,23,
//                34,56,7,8,23,111,222,555,444,666,1, 2, 2 , 3, 4, 4, 5,6,7,8,9,11,22,33,44,55,66,77,88,99,21,22,23,24,25,26,27,28,29,31,32,33,34,35,36,37,38,39,40,41,42,43,44,45,46,47,48,48,49,50,98,97,969,59,49,3,92,
//                23,24,56,54,34,33,44,55,66,77,23,45,54,32,31,31,3,2,33,34,78,79,89,90,32,45,41,4,2,42,43,44,45,46,47,48,49,1,22,33,44,55,66,77,88,99,21,22, 100,111,222,33,444,555,666,23,
//                34,56,7,8,23,111,222,555,444,666, 771);
//
//        int[] arr = {1, 2, 2 , 3, 4, 4, 5,6,7,8,9,11,22,33,44,55,66,77,88,99,21,22,23,24,25,26,27,28,29,31,32,33,34,35,36,37,38,39,40,41,42,43,44,45,46,47,48,48,49,50,98,97,969,59,49,3,92,
//                23,24,56,54,34,33,44,55,66,77,23,45,54,32,31,31,3,2,33,34,78,79,89,90,32,45,41,4,2,42,43,44,45,46,47,48,49,1,22,33,44,55,66,77,88,99,21,22, 100,111,222,33,444,555,666,23,
//                34,56,7,8,23,111,222,555,444,666,1, 2, 2 , 3, 4, 4, 5,6,7,8,9,11,22,33,44,55,66,77,88,99,21,22,23,24,25,26,27,28,29,31,32,33,34,35,36,37,38,39,40,41,42,43,44,45,46,47,48,48,49,50,98,97,969,59,49,3,92,
//                23,24,56,54,34,33,44,55,66,77,23,45,54,32,31,31,3,2,33,34,78,79,89,90,32,45,41,4,2,42,43,44,45,46,47,48,49,1,22,33,44,55,66,77,88,99,21,22, 100,111,222,33,444,555,666,23,
//                34,56,7,8,23,111,222,555,444,666, 771};
//
//        IntStream.rangeClosed( 1, 10 ).forEach( n ->{
//            //times.add(runUsingStream(arr));
//            times.add(runUsingMapAndLoopForSum(arr));
//            //times.add(runUsingMapAndStreamForSum(arr));
//            //times.add(runUsingStreamWithListInput(list));
//            try {
//                Thread.sleep( 1000 );
//            } catch ( InterruptedException e ) {
//                e.printStackTrace();
//            }
//
//            //times.add(runUsingMapAndStreamForSum());
//            //times.add(runUsingStream());
//        } );
//        IntSummaryStatistics collect = times.stream().collect( Collectors.summarizingInt( Long::intValue ) );
//        System.out.println(collect.getAverage());
//    }

//    @Benchmark() @BenchmarkMode( Mode.AverageTime )
//    @Warmup(iterations = 3)
//    @Fork(value = 2)

    @Benchmark @BenchmarkMode( Mode.AverageTime )
    public long standalone() {
        //List<Long> times = new ArrayList<>();

//        List<Integer> list = asList(1, 2, 2 , 3, 4, 4, 5,6,7,8,9,11,22,33,44,55,66,77,88,99,21,22,23,24,25,26,27,28,29,31,32,33,34,35,36,37,38,39,40,41,42,43,44,45,46,47,48,48,49,50,98,97,969,59,49,3,92,
//                23,24,56,54,34,33,44,55,66,77,23,45,54,32,31,31,3,2,33,34,78,79,89,90,32,45,41,4,2,42,43,44,45,46,47,48,49,1,22,33,44,55,66,77,88,99,21,22, 100,111,222,33,444,555,666,23,
//                34,56,7,8,23,111,222,555,444,666,1, 2, 2 , 3, 4, 4, 5,6,7,8,9,11,22,33,44,55,66,77,88,99,21,22,23,24,25,26,27,28,29,31,32,33,34,35,36,37,38,39,40,41,42,43,44,45,46,47,48,48,49,50,98,97,969,59,49,3,92,
//                23,24,56,54,34,33,44,55,66,77,23,45,54,32,31,31,3,2,33,34,78,79,89,90,32,45,41,4,2,42,43,44,45,46,47,48,49,1,22,33,44,55,66,77,88,99,21,22, 100,111,222,33,444,555,666,23,
//                34,56,7,8,23,111,222,555,444,666, 771);

        int[] arr = {1, 2, 2 , 3, 4, 4, 5,6,7,8,9,11,22,33,44,55,66,77,88,99,21,22,23,24,25,26,27,28,29,31,32,33,34,35,36,37,38,39,40,41,42,43,44,45,46,47,48,48,49,50,98,97,969,59,49,3,92,
                23,24,56,54,34,33,44,55,66,77,23,45,54,32,31,31,3,2,33,34,78,79,89,90,32,45,41,4,2,42,43,44,45,46,47,48,49,1,22,33,44,55,66,77,88,99,21,22, 100,111,222,33,444,555,666,23,
                34,56,7,8,23,111,222,555,444,666,1, 2, 2 , 3, 4, 4, 5,6,7,8,9,11,22,33,44,55,66,77,88,99,21,22,23,24,25,26,27,28,29,31,32,33,34,35,36,37,38,39,40,41,42,43,44,45,46,47,48,48,49,50,98,97,969,59,49,3,92,
                23,24,56,54,34,33,44,55,66,77,23,45,54,32,31,31,3,2,33,34,78,79,89,90,32,45,41,4,2,42,43,44,45,46,47,48,49,1,22,33,44,55,66,77,88,99,21,22, 100,111,222,33,444,555,666,23,
                34,56,7,8,23,111,222,555,444,666, 771};

        //return runUsingMapAndLoopForSum(arr);
        return runUsingMapAndStreamForSum(arr);
    }

//    public static void main( String[] args ) {
//
//    }

    public static long   runUsingMapAndLoopForSum(int[] arr) {
        long start1 = System.nanoTime();

        HashMap<Integer, Integer> map = new HashMap<>();
        for(int x = 0; x<arr.length; x++) {
            map.merge( arr[x], 1, ( o, n ) -> o + n );
        }
        int sum = 0;
        for ( Map.Entry<Integer, Integer> e : map.entrySet() ) {
            if (e.getValue() == 1) {
                sum += e.getKey();
            }
        }
        //System.out.println(sum);

        long stop = System.nanoTime();
        long diff = stop - start1;

        return diff;
    }


    public static long  runUsingMapAndStreamForSum(int[] arr) {

        long start1 = System.nanoTime();

        HashMap<Integer, Integer> map = new HashMap<>();
        for(int x = 0; x<arr.length; x++) {
            map.merge( arr[x], 1, ( o, n ) -> o + n );
        }

        //int sum  = map.entrySet().stream().filter( e -> e.getValue() == 1 ).collect( summingInt( Map.Entry::getKey) );
        int sum  = map.entrySet().stream().filter( e -> e.getValue() == 1 ).mapToInt( Map.Entry::getKey ).sum();
        //System.out.println(sum);

        long stop = System.nanoTime();
        long diff = stop - start1;

        return diff;
    }

    public static long runUsingStream(int[] arr) {
        long start1 = System.nanoTime();

        List<Integer> list = Arrays.stream( arr ).boxed().collect( toList() );
        Map<Integer, Long> map = list.stream()
                .collect( Collectors.groupingBy( Integer::intValue, Collectors.counting() ) );
        Integer sum = map.entrySet().stream().filter( e -> e.getValue() == 1 ).collect( summingInt( Map.Entry::getKey) );
        //System.out.println(sum);

        long stop = System.nanoTime();
        long diff = stop - start1;

        return diff;
    }

    public static long runUsingStreamWithListInput(List<Integer> list) {
        long start1 = System.nanoTime();

        Map<Integer, Long> map = list.stream()
                .collect( Collectors.groupingBy( Integer::intValue, Collectors.counting() ) );
        Integer sum = map.entrySet().stream().filter( e -> e.getValue() == 1 ).mapToInt( Map.Entry::getKey ).sum();
        //System.out.println(sum);

        long stop = System.nanoTime();
        long diff = stop - start1;

        return diff;
    }
}
