package com.example.airport_backend.repository;

import com.example.airport_backend.model.dao.FlightEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FlightRepository extends JpaRepository<FlightEntity, Integer>, FlightRepositoryCustom {
}
