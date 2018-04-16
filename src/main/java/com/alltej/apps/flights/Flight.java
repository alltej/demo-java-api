package com.alltej.apps.flights;

/**
 * @author Allan Tejano
 * 4/16/2018
 */
public class Flight {
    private String flightId;
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

    public Flight( String flightId, int cost ) {
        this.flightId = flightId;
        this.cost = cost;
    }
}
