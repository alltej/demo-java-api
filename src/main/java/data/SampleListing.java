package data;

import com.alltej.models.Listing;

import java.util.Arrays;
import java.util.List;

/**
 * @author Allan Tejano
 * 3/5/2018
 */
public class SampleListing {

    private final List<Listing> listings = Arrays.asList(
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

    private String zip = "30041";
    private Integer price = 399999;
    private Integer bedrooms = 5;
    private Integer yearBuilt = 2017;

    public static SampleListing builder() {
        return new SampleListing();
    }

    public static Listing validDefaults() {
        return builder().build();
    }

    public Listing build() {
        return Listing.with( zip, price, bedrooms, yearBuilt );
    }

    public List<Listing> getListings() {
        return listings;
    }
}
