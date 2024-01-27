package com.cenk.FlightSearch.dao;

import com.cenk.FlightSearch.entity.entityFlights;

import java.time.LocalDate;
import java.util.List;

public interface FlightsDao {
    entityFlights save(entityFlights EntityFlights);
    List<entityFlights> findAll();
    List<entityFlights> findFlights(String departureAirport, String arrivalAirport,
                                           LocalDate departureDate, LocalDate returnDate);
    entityFlights findById(int id);
    entityFlights update(entityFlights EntityFlights);
    entityFlights remove(int id);
}
