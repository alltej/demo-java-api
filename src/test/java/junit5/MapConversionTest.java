package junit5;

import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

/**
 * @author Allan Tejano
 * 3/5/2018
 */
public class MapConversionTest {

    @Test public void map_to_list() {
        IntStream.rangeClosed(1, 10).forEach(x-> {
            StringBuilder sb = new StringBuilder(x);
            IntStream.rangeClosed(1, 10).forEach(y -> {
                final Integer product = x * y;
                sb.append(product);
            });
            System.out.println(sb.toString());
        });
    }
}
