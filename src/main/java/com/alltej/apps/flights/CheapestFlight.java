package com.alltej.apps.flights;

import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author Allan Tejano
 * 4/16/2018
 */
class Flight {
    private String flightId;
    private String airline;
    private int cost;

    public String getFlightId() {
        return flightId;
    }

    public void setFlightId( String flightId ) {
        this.flightId = flightId;
    }

    public int getCost() {
        return cost;
    }

    public void setCost( int cost ) {
        this.cost = cost;
    }

    public Flight( String flightId, int cost, String airline ) {
        this.flightId = flightId;
        this.cost = cost;
        this.airline = airline;
    }

    @Override public String toString() {
        return "Flight{" + "flightId='" + flightId + '\'' + ", airline='" + airline + '\'' + ", cost=" + cost + '}';
    }
}

public class CheapestFlight {

    List<Flight> flights =  Arrays.asList(new Flight("F2G", 35, "UA"),
            new Flight("A2C", 36, "UA"),
            new Flight("A2C", 46, "DELTA"),
            new Flight("A2C", 42, "SW"),
            new Flight("B2C", 10, "DELTA"),
            new Flight("B2C", 19, "UA"),
            new Flight("C2S", 49, "DELTA"),
            new Flight("C2S", 49, "DELTA"),
            new Flight("C2S", 55, "SW"),
            new Flight("C2N", 59, "UA"),
            new Flight("C2N", 79, "DELTA"));

    @Test public void cheapest_flight_by_flight_id() {
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
            System.out.println(s.toString());
        } );
    }

    @Test public void stats_by_flight_id() {
        Map<String, IntSummaryStatistics> collect = flights.stream()
                .collect( Collectors.groupingBy( Flight::getFlightId, Collectors.summarizingInt( Flight::getCost ) ) );
        collect.entrySet().forEach( c -> {
            System.out.println(c.getKey());
            System.out.println(c.getValue());
            System.out.println("***********");
        } );
    }

}
