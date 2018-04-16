package com.alltej.apps.flights;

import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author Allan Tejano
 * 4/16/2018
 */
public class CheapestFlight {

    List<Flight> flights =  Arrays.asList(new Flight("AA1", 35),
            new Flight("AA2", 36), new Flight("BB1", 10),
            new Flight("AA2", 46), new Flight("BB1", 19),
            new Flight("CC1", 49), new Flight("CC1", 59),
            new Flight("CC1", 59), new Flight("CC1", 79));

    @Test public void cheapest_flight_by_flight_id() {
        Map<String, Flight> collect = flights.stream().collect( Collectors.groupingBy( Flight::getFlightId, Collectors
                .collectingAndThen( Collectors.reducing( ( f1, f2 ) -> f1.getCost() > f2.getCost() ? f1 : f2 ),
                        Optional::get ) ) );

        Map<String, List<Flight>> flightsById = flights.stream()
                .collect( Collectors.groupingBy( Flight::getFlightId, Collectors.toList() ) );
        Map<String, Flight> cflights = new HashMap<>();
        flightsById.entrySet().stream().forEach( f -> {
            Flight flight = f.getValue().stream().collect( Collectors
                    .collectingAndThen( Collectors.reducing( ( f1, f2 ) -> f1.getCost() > f2.getCost() ? f2 : f1 ),
                            Optional::get ) );
            cflights.put( f.getKey(), flight );
        } );
        cflights.entrySet().stream().forEach( s ->{
            System.out.println(s.getKey() + "::" + s.getValue().getCost());
        } );
    }

}
