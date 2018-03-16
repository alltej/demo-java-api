package junit5;

import com.alltej.models.Listing;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class FilterTest {

    private static final List<Listing> listings = Arrays.asList(
            Listing.with(  "30000", 200000 , 4, 2013),
            Listing.with(  "30000",220000 , 4, 2013),
            Listing.with(  "30000",240000 , 5, 2013),
            Listing.with( "30000",250000 , 4, 2014),
            Listing.with( "30000",270000 , 5, 2014),
            Listing.with( "30000",290000 , 5, 2014),
            Listing.with( "30000", 300000 , 4, 2015),
            Listing.with( "30000", 320000 , 5, 2015),
            Listing.with( "30000", 340000 , 5, 2015),
            Listing.with( "30000", 300000 , 4, 2016),
            Listing.with(  "30000",320000 , 5, 2016),
            Listing.with(  "30000",340000 , 5, 2016),
            Listing.with(  "30000",340000 , 4, 2017),
            Listing.with( "30000", 360000 , 5, 2017),
            Listing.with(  "30000",380000 , 5, 2017));

    @BeforeEach
    void init() {

    }

    @Test
    void lambdaExpressions() {
        List<Integer> numbers = Arrays.asList(1, 2, 3);
        assertTrue(numbers.stream()
                .mapToInt(i -> i)
                .sum() > 5, "Sum should be greater than 5");
    }

    @Test
    void filter_w_forEach() {
        listings.stream()
                .filter(l -> l.getBedrooms()==5 && l.getYearBuilt() > 2013)
                .forEach( System.out::println);
    }

    @Test
    void filter_average() {
        //Map<Integer, Integer> m = new HashMap<>();
        OptionalDouble averagePrice = listings.stream()
                .filter( l -> l.getBedrooms() == 5 && l.getYearBuilt() > 2013 )
                .mapToDouble( Listing::getPrice ).average();
        System.out.println(averagePrice);
    }


}

