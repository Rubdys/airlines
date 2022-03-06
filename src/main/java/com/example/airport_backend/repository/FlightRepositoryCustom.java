package com.example.airport_backend.repository;

import com.example.airport_backend.model.dao.FlightEntity;

import java.util.List;

public interface FlightRepositoryCustom {

    List<FlightEntity> getByFilter(String arrivalCountry, String departureCountry, String arrivalTime, String departureTime);

}
