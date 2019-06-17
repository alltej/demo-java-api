package com.alltej.apps.sitemapping;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.*;

import static java.util.Arrays.asList;
import static java.util.stream.Collectors.*;

/**
 * @author Allan Tejano
 * 4/9/2018
 */
public class MapConversionApp_prob_v2 {
    public static void main( String[] args ) {
        Collection<DbRecord> records = asList(
                new DbRecord( LocalDateTime.of(2018, 1, 1, 1,1,1), BigDecimal.valueOf( 111.11 ), "site1" ),
                new DbRecord( LocalDateTime.of(2018, 1, 1, 1,2,2), BigDecimal.valueOf( 122.22 ), "site1" ),
                new DbRecord( LocalDateTime.of(2018, 1, 1, 1,3,3), BigDecimal.valueOf( 133.33 ), "site1" ),
                new DbRecord( LocalDateTime.of(2018, 1, 1, 2,4,4), BigDecimal.valueOf( 244.44 ), "site2" ),
                new DbRecord( LocalDateTime.of(2018, 1, 1, 2,5,5), BigDecimal.valueOf( 255.55 ), "site2" ),
                new DbRecord( LocalDateTime.of(2018, 1, 1, 2,6,6), BigDecimal.valueOf( 266.66 ), "site2" ),
                new DbRecord( LocalDateTime.of(2018, 1, 1, 3,4,4), BigDecimal.valueOf( 344.44 ), "site3" ),
                new DbRecord( LocalDateTime.of(2018, 1, 1, 3,5,5), BigDecimal.valueOf( 355.55 ), "site3" ),
                new DbRecord( LocalDateTime.of(2018, 1, 1, 3,6,6), BigDecimal.valueOf( 366.66 ), "site3" )
        );

        SiteValues sv = convertResultsUsingCollectorsMap( records );
        sv.getSiteToValues().entrySet().forEach( stv ->  {
            System.out.println(stv.getKey());
            stv.getValue().forEach( v ->{
                System.out.println("time:" + v.getTime() + "::value:" + v.getValue());
            } );
        });
    }

    /* Convert to map of sites with List of Measurements for that site*/
    public static SiteValues convertResults(Collection<DbRecord> records) {
        //group by site with list of DbRecords
        //prob: create a return of type SiteValues => HashMap<Site, List<Measurement>>

        //1. First step - create Map<String, List<DbRecord>>
        Map<String, List<DbRecord>> collect = records.stream().collect(groupingBy(DbRecord::getSiteName, toList()));

        //2. Populate HashMap<String, List<Meaurement>> using forEach
        return null;
    }


    public static SiteValues convertResultsUsingCollectorsMap(Collection<DbRecord> records) {

        //1. create Map<String, List<DbRecord>>
        Map<String, List<DbRecord>> collect = records.stream().collect(groupingBy(DbRecord::getSiteName, toList()));

        //2. create Map<String, List<Meaurement>> using Collectors.toMap
        return null;
    }
}
