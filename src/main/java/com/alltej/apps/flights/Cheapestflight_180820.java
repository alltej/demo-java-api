package com.alltej.apps.flights;

import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.reducing;
import static java.util.stream.Collectors.summarizingInt;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Cheapestflight_180820 {

    List<Flight> flights =  Arrays.asList(new Flight("F2G", 35, "UA"),
            new Flight("A2C", 36, "UA"),
            new Flight("A2C", 46, "DELTA"),
            new Flight("A2C", 42, "SW"),
            new Flight("A2C", 44, "SW"),
            new Flight("B2C", 10, "DELTA"),
            new Flight("B2C", 19, "UA"),
            new Flight("C2S", 49, "DELTA"),
            new Flight("C2S", 49, "DELTA"),
            new Flight("C2S", 55, "SW"),
            new Flight("C2N", 59, "UA"),
            new Flight("C2N", 79, "DELTA"));

    @Test
    public void cheapest_flight_by_flight_id() {
        Map<String, Flight> cheapFlightsHash = flights.stream()
                .collect(Collectors.groupingBy(Flight::getFlightId,
                        collectingAndThen(
                                reducing((f1, f2) -> f1.getCost() > f2.getCost() ? f1 : f2), Optional::get)));

        Flight a2c = cheapFlightsHash.get( "A2C" );
        assertEquals( 36, a2c.getCost() );
        Flight c2N = cheapFlightsHash.get( "C2N" );
        assertEquals( 59, c2N.getCost() );

    }

    @Test public void stats_by_flight_id() {

        Map<String, IntSummaryStatistics> collect = flights.stream()
                .collect(Collectors.groupingBy(Flight::getFlightId, summarizingInt(Flight::getCost)));
        IntSummaryStatistics stat = collect.get( "A2C" );
        assertEquals( 36, stat.getMin() );
        assertEquals( 46, stat.getMax() );
        assertEquals( 42.0, stat.getAverage() );
    }

}
