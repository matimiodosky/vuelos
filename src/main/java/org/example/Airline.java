package org.example;

import java.util.ArrayList;
import java.util.List;

public class Airline {

    private final String name;
    private final List<Flight> flights;
    private final List<Reservation> reservations;
    private final List<Passenger> passengers;

    public Airline(String name) {
        this.name = name;
        this.flights = new ArrayList<>();
        this.reservations = new ArrayList<>();
        this.passengers = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public Flight addFlight(String code, Airport from, Airport to, int capacity) {
        Flight flight = new Flight(code, from, to, capacity);
        this.flights.add(flight);
        return flight;
    }

    public void addPassenger(Passenger passenger) {
        this.passengers.add(passenger);
    }

    public Reservation addReservation(String flightCode, String passengerId) {
        Flight flight = this.getFlightByCode(flightCode);

        Passenger passenger = this.getPassengerById(passengerId);

        Reservation reservation = new Reservation(this.getReservationCode(), flight, passenger);
        this.reservations.add(reservation);
        return reservation;
    }

    private Passenger getPassengerById(String passengerId) {
        for (Passenger passenger : this.passengers) {
            if (passenger.getId().equals(passengerId)) {
                return passenger;
            }
        }
        throw new RuntimeException("Passenger not found");
    }

    private String getReservationCode() {
        return this.reservations.size() + 1 + "";
    }

    private Flight getFlightByCode(String flightCode) {
        for (Flight flight : this.flights) {
            if (flight.getCode().equals(flightCode)) {
                return flight;
            }
        }
        throw new RuntimeException("Flight not found");
    }

    public List<Passenger> getPassengersForFlight(String code) {
        List<Passenger> passengers = new ArrayList<>();
        for (Reservation reservation : this.reservations) {
            if (reservation.getFlight().getCode().equals(code)) {
                passengers.add(reservation.getPassenger());
            }
        }
        return passengers;
    }

    public Passenger addPassenger(String johnDoe, String number) {
        Passenger passenger = new Passenger(johnDoe, number);
        this.passengers.add(passenger);
        return passenger;
    }

    public List<Flight> getFlightsWithSpace(Airport from, Airport to) {
        List<Flight> flightsWithSpace = new ArrayList<>();
        for (Flight flight : this.flights) {
            if (flight.getFrom().equals(from) && flight.getTo().equals(to)) {
                if (this.getPassengersForFlight(flight.getCode()).size() < flight.getCapacity()) {
                    flightsWithSpace.add(flight);
                }
            }
        }
        return flightsWithSpace;
    }
}
