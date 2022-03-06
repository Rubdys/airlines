package com.example.airport_backend.repository;

import com.example.airport_backend.model.dao.AirportEntity;
import com.example.airport_backend.model.dao.FlightEntity;
import com.example.airport_backend.model.enums.Country;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import javax.persistence.metamodel.EntityType;
import javax.persistence.metamodel.Metamodel;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Repository
@Transactional(readOnly = true)
public class FlightRepositoryImpl implements FlightRepositoryCustom {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<FlightEntity> getByFilter(String arrivalCountry, String departureCountry, String startTime, String backTime) {
        startTime = startTime.replace(' ','-');
        DateTimeFormatter formatter = new DateTimeFormatterBuilder()
                .appendPattern("MMM-dd-yyyy")
                .toFormatter(Locale.ENGLISH);


        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<FlightEntity> criteriaQuery = criteriaBuilder.createQuery(FlightEntity.class);

        Metamodel m = entityManager.getMetamodel();
        EntityType<FlightEntity> FlightEntity_ = m.entity(FlightEntity.class);

        Root<FlightEntity> root = criteriaQuery.from(FlightEntity.class);
        Join<FlightEntity, AirportEntity> arrival = root.join(FlightEntity_.getSingularAttribute("arrivalAirport", AirportEntity.class));
        Join<FlightEntity, AirportEntity> departure = root.join(FlightEntity_.getSingularAttribute("departureAirport", AirportEntity.class));



        List<Predicate> predicates = new ArrayList<>();
        if(arrivalCountry != null){
            predicates.add(criteriaBuilder.equal(arrival.get("countryOfAirport"), Country.fromString(arrivalCountry)));
        }
        if(departureCountry != null){
            predicates.add(criteriaBuilder.equal(departure.get("countryOfAirport"), Country.fromString(departureCountry)));
        }
        if(startTime != null){
            predicates.add(criteriaBuilder.equal(root.get("timeOfArrival"), LocalDate.parse(startTime, formatter)));
        }
        if(backTime != null){
            predicates.add(criteriaBuilder.equal(root.get("timeOfArrival"), LocalDate.parse(backTime, formatter)));
        }


        criteriaQuery.select(root).where(predicates.toArray(new Predicate[0]));
        TypedQuery<FlightEntity> query = entityManager.createQuery(criteriaQuery);
        return query.getResultList();
    }
}
