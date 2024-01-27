package com.cenk.FlightSearch.service;

import com.cenk.FlightSearch.dao.AirportsDao;
import com.cenk.FlightSearch.entity.entityAirports;
import com.cenk.FlightSearch.entity.entityFlights;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AirportsServiceImpl implements AirportsService{

    private AirportsDao airportsDao;

    @Autowired
    public AirportsServiceImpl(AirportsDao airportsDao) {
        this.airportsDao = airportsDao;
    }


    @Override
    public entityAirports save(entityAirports EntityAirports) {
        return airportsDao.save(EntityAirports);
    }

    @Override
    public List<entityAirports> findAll() {
        return airportsDao.findAll();
    }

    @Override
    public entityAirports findById(int id) {
        return airportsDao.findById(id);
    }


    @Override
    public entityAirports update(entityAirports EntityAirports) {
        return airportsDao.update(EntityAirports);
    }

    @Override
    public entityAirports remove(int id) {
        return airportsDao.remove(id);
    }
}
