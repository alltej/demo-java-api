package com.alltej.apps.flights;

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
