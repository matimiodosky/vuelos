package org.example;

public class Reservation {

    private final String code;
    private final Flight flight;
    private final Passenger passenger;

    public Reservation(String code, Flight flight, Passenger passenger) {
        this.code = code;
        this.flight = flight;
        this.passenger = passenger;
    }

    public Flight getFlight() {
        return flight;
    }

    public Passenger getPassenger() {
        return passenger;
    }
}
