package com.cenk.FlightSearch.dao;

import com.cenk.FlightSearch.entity.entityFlights;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PostMapping;
import java.util.ArrayList;


import java.time.LocalDate;
import java.util.List;
@Repository
public class FlightsDaoImpl implements   FlightsDao{

    private EntityManager entityManager;

    @Autowired
    public FlightsDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Transactional
    @Override
    public entityFlights save(entityFlights EntityFlights) {
        entityManager.persist(EntityFlights);
        return null;
    }
    @Override

    public entityFlights findById(int id){
        return entityManager.find(entityFlights.class,id) ;
    };

    @Override
    public List<entityFlights> findAll() {
        TypedQuery<entityFlights> query = entityManager.createQuery("SELECT f FROM entityFlights f",
                entityFlights.class);
        return query.getResultList();
    }

    @Override
    public List<entityFlights> findFlights(String departureAirport, String arrivalAirport,
                                           LocalDate departureDate, LocalDate returnDate) {

        List<entityFlights> result = null;
        if(returnDate == null) {


            TypedQuery<entityFlights> query = entityManager.createQuery(


                    "SELECT e FROM entityFlights e WHERE e.departureAirport = :departureAirport AND " +
                            "e.arrivalAirport = :arrivalAirport AND e.departureDate = :departureDate AND " +
                            "e.returnDate = null",
                    entityFlights.class);

            query.setParameter("departureAirport", departureAirport);
            query.setParameter("arrivalAirport", arrivalAirport);
            query.setParameter("departureDate", departureDate);



             result = query.getResultList();
        }
else {


            TypedQuery<entityFlights> query = entityManager.createQuery(


                    "SELECT e FROM entityFlights e WHERE e.departureAirport = :departureAirport AND " +
                            "e.arrivalAirport = :arrivalAirport AND e.departureDate = :departureDate AND " +
                            "e.returnDate = :returnDate",
                    entityFlights.class);

            query.setParameter("departureAirport", departureAirport);
            query.setParameter("arrivalAirport", arrivalAirport);
            query.setParameter("departureDate", departureDate);
            query.setParameter("returnDate",returnDate);


            result = query.getResultList();
        }
       return result;
    }


    @Transactional
    @Override
    public entityFlights update(entityFlights EntityFlights) {
        entityFlights updatedFlights = entityManager.merge(EntityFlights);
        return updatedFlights;
    }

    @Override
    public entityFlights remove(int id) {
         entityFlights EntityFlights = findById(id);
         entityManager.remove(EntityFlights);
         return  EntityFlights;

    }
}
