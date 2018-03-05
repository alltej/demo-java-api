package data;

import com.alltej.models.Listing;

/**
 * @author Allan Tejano
 * 3/5/2018
 */
public class SampleListing {

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
}
