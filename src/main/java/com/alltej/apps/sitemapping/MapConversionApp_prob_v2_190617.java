package com.alltej.apps.sitemapping;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

import static java.util.Arrays.asList;
import static java.util.stream.Collectors.*;

/**
 * @author Allan Tejano
 * 4/9/2018
 */
public class MapConversionApp_prob_v2_190617 {
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

        SiteValues sv2 = convertResultsUsingCollectorsMap( records );
        sv2.getSiteToValues().entrySet().forEach( stv ->  {
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
        Map<String, List<DbRecord>> collect = records.stream().collect(Collectors.groupingBy(DbRecord::getSiteName, toList()));
        //2. Populate HashMap<String, List<Meaurement>> using forEach
        HashMap<String, List<Meaurement>> map = new HashMap<>();
        collect.entrySet().stream().forEach(c -> {
            List<Meaurement> list = new ArrayList<>();
            c.getValue().stream().forEach(m ->{
                list.add(new Meaurement(m.getTime(), m.getValue()));
            });
            map.put(c.getKey(), list);
        });
        return new SiteValues(map);
    }


    public static SiteValues convertResultsUsingCollectorsMap(Collection<DbRecord> records) {
        System.out.println("*****convertResultsUsingCollectorsMap***");
        //1. create Map<String, List<DbRecord>>
        Map<String, List<DbRecord>> collect = records.stream().collect(groupingBy(DbRecord::getSiteName,toList()));

        //2. create Map<String, List<Meaurement>> using Collectors.toMap
        Map<String, List<Meaurement>> map = collect.entrySet().stream().collect(toMap(
                e -> e.getKey(),
                e -> e.getValue().stream().map(l -> new Meaurement(l.getTime(), l.getValue())).collect(toList())
        ));
        return new SiteValues(map);
    }
}
