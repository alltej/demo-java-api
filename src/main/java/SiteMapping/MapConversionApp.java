package SiteMapping;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

import static java.util.Arrays.asList;
import static java.util.stream.Collectors.toList;

/**
 * @author Allan Tejano
 * 3/6/2018
 * ?g?lys?s
 */
public class MapConversionApp {
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

    public static SiteValues convertResults(Collection<DbRecord> records) {
        Map<String, List<DbRecord>> siteByDbRecords = records.stream()
                .collect( Collectors.groupingBy( DbRecord::getSiteName, toList()));

        Map<String, List<Meaurement>> siteMaps = new HashMap<>();
        siteByDbRecords.entrySet().stream().forEach( s ->
            {
                List<Meaurement> meaurements = s.getValue().stream().map( v -> new Meaurement( v.getTime(), v.getValue() ) ).collect( toList() );
                siteMaps.put( s.getKey(), meaurements );
            }
        );
        return new SiteValues( siteMaps );
    }






















    public static SiteValues convertResults_20180312(Collection<DbRecord> records) {
        Map<String, List<DbRecord>> siteWithDbRecords = records.stream()
                .collect( Collectors.groupingBy( DbRecord::getSiteName ) );

        Map<String, List<Meaurement>> siteWithMeasurements = new HashMap<>();
        siteWithDbRecords.entrySet().forEach( s ->{
            List<Meaurement> dbRecords = s.getValue().stream()
                    .map( r -> new Meaurement( r.getTime(), r.getValue() ) )
                    .collect( toList() );
            siteWithMeasurements.put(  s.getKey() , dbRecords ) ;

        } );
        //siteWithMeasurements.entrySet().stream().collect(Collectors.s )
        return new SiteValues( siteWithMeasurements );
    }


    public static SiteValues convertResults_20180309(Collection<DbRecord> records) {
        Map<String, List<DbRecord>> sitesWDbRecords = records.stream()
                .collect( Collectors.groupingBy( DbRecord::getSiteName ) );

        Map<String, List<Meaurement>> sitesWMeasurements = new HashMap<>();
        sitesWDbRecords.entrySet().forEach( s ->  {
            List<Meaurement> meaurements = s.getValue().stream().map( l -> new Meaurement( l.getTime(), l.getValue() ) )
                    .collect( toList() );
            sitesWMeasurements.put( s.getKey(), meaurements );
        });
        return new SiteValues( sitesWMeasurements );
    }

    private static SiteValues convertResults_working_sln_1( Collection<DbRecord> records ) {

        Map<String, List<DbRecord>> collect = records.stream()
                .collect( Collectors.groupingBy( DbRecord::getSiteName ) );
        Map<String, List<Meaurement>> siteToValues = new HashMap<>();
        collect.entrySet().forEach( c -> {
            List<Meaurement> meaurements = c.getValue().stream().map( v -> new Meaurement( v.getTime(), v.getValue() ) )
                    .collect( toList() );
            siteToValues.put( c.getKey(), meaurements );
        } );
        return new SiteValues( siteToValues );
    }
}
