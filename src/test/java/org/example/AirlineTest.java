package org.example;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.example.Airport.AEP;
import static org.junit.jupiter.api.Assertions.assertEquals;

class AirlineTest {

    @Test
    public void canCreateReservation(){

        Airline airline = new Airline("Aerolineas Argentinas");

        Flight flight = airline.addFlight("XYZ987", AEP, Airport.BRC, 100);
        Passenger passenger = airline.addPassenger("John Doe", "123");
        airline.addReservation(flight.getCode(), passenger.getId());

        List<Passenger> passangerList = airline.getPassengersForFlight(flight.getCode());

        assertEquals(1, passangerList.size());
        assertEquals(passangerList.getFirst().getId(), passenger.getId());
    }

    @Test
    public void flightWithSpaceGetsListed(){

            Airline airline = new Airline("Aerolineas Argentinas");

            Flight flight = airline.addFlight("XYZ987", AEP, Airport.BRC, 100);
            Passenger passenger = airline.addPassenger("John Doe", "123");
            airline.addReservation(flight.getCode(), passenger.getId());

            List<Flight> flightList = airline.getFlightsWithSpace(Airport.AEP, Airport.BRC);

            assertEquals(1, flightList.size());
            assertEquals(flightList.getFirst().getCode(), flight.getCode());
    }

    @Test
    public void flightWithNoSpaceDoesNotGetListed(){

            Airline airline = new Airline("Aerolineas Argentinas");

            Flight flight = airline.addFlight("XYZ987", AEP, Airport.BRC, 1);
            Passenger passenger = airline.addPassenger("John Doe", "123");
            airline.addReservation(flight.getCode(), passenger.getId());

            List<Flight> flightList = airline.getFlightsWithSpace(Airport.AEP, Airport.BRC);

            assertEquals(0, flightList.size());
    }

}