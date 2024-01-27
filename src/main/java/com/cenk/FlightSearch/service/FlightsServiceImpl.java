package com.cenk.FlightSearch.service;

import com.cenk.FlightSearch.dao.FlightsDao;
import com.cenk.FlightSearch.entity.entityFlights;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
public class FlightsServiceImpl implements FlightsService{

    private FlightsDao flightsDao;

    @Autowired
    public FlightsServiceImpl(FlightsDao flightsDao) {
        this.flightsDao = flightsDao;
    }

    @Override
    public List<entityFlights> findAll() {
        return flightsDao.findAll();
    }

    @Override
    public entityFlights save(entityFlights EntityFlights) {
        return flightsDao.save(EntityFlights);
    }

    @Override
    public entityFlights findById(int id) {
        return flightsDao.findById(id);
    }

    @Override
    public List<entityFlights> findFlights(String departureAirport, String arrivalAirport, LocalDate departureDate, LocalDate returnDate) {
        return flightsDao.findFlights(departureAirport,arrivalAirport,departureDate,returnDate);
    }

    @Override
    public entityFlights update(entityFlights EntityFlights) {
        return flightsDao.update(EntityFlights);
    }

    @Override
    @Transactional
    public entityFlights remove(int id) {
        return flightsDao.remove(id);
    }
}
