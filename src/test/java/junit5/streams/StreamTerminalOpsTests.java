package junit5.streams;

import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.Arrays.asList;
import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Allan Tejano
 * 4/19/2018
 */
public class StreamTerminalOpsTests {
    @Test public void terminal_operation_foreach() {
        Stream.of( "Hello", "World" ).forEach( p -> System.out.println( p ) );
    }

    @Test public void terminal_operation_toArray() {
        Object[] objects = Stream.of( 1, 2 ).toArray();
        assertTrue( objects.length == 2 );
    }

    @Test public void terminal_operation_reduce() {
        int sum = IntStream.of( 1, 2, 3, 4 ).reduce( 0, ( a, b ) -> a + b );
        assertEquals( 10, sum );
    }

    @Test public void terminal_operation_collect() {
        Set<String> stringSet = Stream.of( "some", "one", "some", "one" ).collect( Collectors.toSet() );
        assertTrue( stringSet.contains( "some" ) );
        assertTrue( stringSet.size() == 2 );
    }

    @Test public void terminal_operation_min() {
        OptionalInt minimum = IntStream.of( 1, 2, 3 ).min();
        assertEquals( 1, minimum.getAsInt() );
    }

    @Test public void terminal_operation_max() {
        OptionalDouble max = Stream.of( 1d, 2d, 3d ).mapToDouble( Double::doubleValue ).max();
        //assertEquals( 3d, max.getAsDouble(), 0.0d );
        assertEquals( 3, max.getAsDouble());
    }

    @Test public void terminal_operation_count() {
        long count = Stream.of( "one" ).count();
        assertEquals( 1, count );
    }

    @Test public void terminal_operation_anymatch() {
        boolean lengthOver5 = Stream.of( "two", "three", "eighteen" ).anyMatch( s -> s.length() > 5 );
        assertTrue( lengthOver5 );
    }

    @Test public void terminal_operation_allmatch() {

        List<String> cookies = asList( "Peanut Butter Cookies", "Oatmeal-Raisin Cookies", "Basic Chocolate Chip Cookies" );

        boolean containCookies = cookies.stream().allMatch( p -> p.contains( "Cookies" ) );

        assertTrue( containCookies );
    }

    @Test
    public void terminal_operation_nonematch() {

        boolean noElementEqualTo5 = IntStream.of(1, 2, 3)
                .noneMatch(p -> p == 5);

        assertTrue(noElementEqualTo5);
    }

    @Test
    public void terminal_operation_findfirst() {

        Optional<String> val = Stream.of("one", "two").findFirst();

        assertEquals("one", val.get());
    }
    @Test
    public void terminal_operation_findany() {

        Optional<String> val = Stream.of("one", "two").findAny();

        assertEquals("one", val.get());
    }

}
