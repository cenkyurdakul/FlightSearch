package com.cenk.FlightSearch.service;

import com.cenk.FlightSearch.entity.entityFlights;

import java.time.LocalDate;
import java.util.List;

public interface FlightsService {
    List<entityFlights> findAll();
    entityFlights save(entityFlights EntityFlights);

    entityFlights findById(int id);

    List<entityFlights> findFlights (String departureAirport, String arrivalAirport,
    java.time.LocalDate departureDate, LocalDate returnDate);
    entityFlights update(entityFlights EntityFlights);

    entityFlights remove(int id);

}
