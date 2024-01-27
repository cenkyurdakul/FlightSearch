package com.cenk.FlightSearch.service;

import com.cenk.FlightSearch.entity.entityAirports;
import com.cenk.FlightSearch.entity.entityFlights;

import java.util.List;

public interface AirportsService {
    entityAirports save (entityAirports EntityAirports);
    List<entityAirports> findAll();
    entityAirports findById(int id);
    entityAirports update(entityAirports EntityAirports);
    entityAirports remove(int id);
}
