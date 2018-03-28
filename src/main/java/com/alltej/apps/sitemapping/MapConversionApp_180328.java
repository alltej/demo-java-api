package com.alltej.apps.sitemapping;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

import static java.util.Arrays.asList;
import static java.util.stream.Collectors.toList;
/**
 * @author Allan Tejano
 * 3/28/2018
 */
public class MapConversionApp_180328 {
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

        SiteValues sv = convertResults( records );
        sv.getSiteToValues().entrySet().forEach( stv ->  {
            System.out.println(stv.getKey());
            stv.getValue().forEach( v ->{
                System.out.println("time:" + v.getTime() + "::value:" + v.getValue());
            } );
        });
    }

    /* Convert to map of sites with List of Measurements for that site*/
    public static SiteValues convertResults(Collection<DbRecord> records) {
        Map<String, List<DbRecord>> collect = records.stream()
                .collect( Collectors.groupingBy( DbRecord::getSiteName, toList() ) );

        Map<String, List<Meaurement>> measurements = new HashMap<>();
        collect.entrySet().stream().forEach( c ->{
            List<Meaurement> list = c.getValue().stream().map( v -> new Meaurement( v.getTime(), v.getValue() ) )
                    .collect( toList() );
            measurements.put( c.getKey(), list );
        } );

        return new SiteValues( measurements );
    }

}
