package com.alltej.apps.cox;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Allan Tejano
 * 5/4/2018
 */
public class BenchMarkFindDupUsingStream {

    public static void main( String[] args ) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(Benchmark.class.getSimpleName())
                .forks(1)
                .build();
        new Runner(opt).run();
    }

    @Benchmark
    public long firstBenchmark() {

        int[] arr = {1, 2, 2 , 3, 4, 4, 5,6,7,8,9,11,22,33,44,55,66,77,88,99,21,22,23,24,25,26,27,28,29,31,32,33,34,35,36,37,38,39,40,41,42,43,44,45,46,47,48,48,49,50,98,97,969,59,49,3,92,
                23,24,56,54,34,33,44,55,66,77,23,45,54,32,31,31,3,2,33,34,78,79,89,90,32,45,41,4,2,42,43,44,45,46,47,48,49,1,22,33,44,55,66,77,88,99,21,22, 100,111,222,33,444,555,666,23,
                34,56,7,8,23,111,222,555,444,666,1, 2, 2 , 3, 4, 4, 5,6,7,8,9,11,22,33,44,55,66,77,88,99,21,22,23,24,25,26,27,28,29,31,32,33,34,35,36,37,38,39,40,41,42,43,44,45,46,47,48,48,49,50,98,97,969,59,49,3,92,
                23,24,56,54,34,33,44,55,66,77,23,45,54,32,31,31,3,2,33,34,78,79,89,90,32,45,41,4,2,42,43,44,45,46,47,48,49,1,22,33,44,55,66,77,88,99,21,22, 100,111,222,33,444,555,666,23,
                34,56,7,8,23,111,222,555,444,666, 771};

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
}
