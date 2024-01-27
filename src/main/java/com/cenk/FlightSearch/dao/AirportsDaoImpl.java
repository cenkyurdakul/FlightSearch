package com.cenk.FlightSearch.dao;

import com.cenk.FlightSearch.entity.entityAirports;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AirportsDaoImpl implements AirportsDao{

    private EntityManager entityManager;

    @Autowired
    public AirportsDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Transactional
    @Override
    public entityAirports save(entityAirports EntityAirports) {
        entityManager.persist(EntityAirports);
        return null;
    }

    @Override
    public List<entityAirports> findAll() {
        TypedQuery<entityAirports> query = entityManager.createQuery("SELECT a FROM entityAirports a",
                entityAirports.class);
        return query.getResultList();
    }

    @Override
    public entityAirports findById(int id) {
        return entityManager.find(entityAirports.class,id);
    }

    @Override
    public entityAirports update(entityAirports EntityAirports) {
        return entityManager.merge(EntityAirports);
    }

    @Override
    public entityAirports remove(int id) {
        entityAirports EntityAirports = findById(id);
        entityManager.remove(EntityAirports);
        return  EntityAirports;
    }
}
