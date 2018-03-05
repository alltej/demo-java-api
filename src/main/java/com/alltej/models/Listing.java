package com.alltej.models;

import lombok.Data;

@Data
public class Listing {
    private String zip;
    private Integer price;
    private Integer bedrooms;
    private Integer yearBuilt;

    private Listing( String zip, Integer price, Integer bedrooms, Integer yearBuilt ) {
        this.zip = zip;
        this.price = price;
        this.bedrooms = bedrooms;
        this.yearBuilt = yearBuilt;
    }

    public static final Listing with(String zip, Integer price, Integer bedrooms, Integer yearBuilt ) {
        return new Listing( zip, price,  bedrooms,  yearBuilt );
    }
}
