package junit5;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.Arrays.asList;

/**
 * @author Allan Tejano
 * 4/16/2018
 */
public class CollectionsTest {
    @Test public void main() {
        Map<String, List<String>> collect = asList( "a", "z", "d", "e", "f", "a", "b", "a" ).stream()
                .collect( Collectors.groupingBy( String::toString, Collectors.toList() ));
                //collect.entrySet().forEach( System.out::println );
        Map<String, Integer> scount = new HashMap<>();
        collect.entrySet().stream()
                .forEach( s -> System.out.println( s.getKey() + "::" + s.getValue() ) );
    }
    @Test public void main2() {
//        Employee employee = ee.stream().collect( Collectors
//                .collectingAndThen( Collectors.reducing( ( e1, e2 ) -> e1.getSalary() > e2.getSalary() ? e1 : e2 ),
//                        Optional::get ) );
//        System.out.println(employee);
        Map<String, Long> collect = asList( "a", "z", "d", "e", "f", "a", "b", "a" ).stream()
                .collect( Collectors.groupingBy( String::toString, Collectors.counting() ) );
        Map.Entry<String, Long> entry = collect.entrySet().stream().collect( Collectors
                .collectingAndThen( Collectors.reducing( ( i1, i2 ) -> i1.getValue() > i2.getValue() ? i1 : i2 ),
                        Optional::get ) );
        System.out.println(entry);
    }
//    @Test public void main2() {
//        asList( "a", "z", "d", "e", "f", "a", "b", "a" ).stream()
//                .collect( Collectors.groupingBy( String::toString, Collectors.collectingAndThen( s ->
//                    Collectors.counting(s)) ));
//                collect.entrySet().forEach( System.out::println );
//    }
}
