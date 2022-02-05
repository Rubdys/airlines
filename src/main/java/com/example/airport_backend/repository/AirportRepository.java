package com.example.airport_backend.repository;

import com.example.airport_backend.model.dao.AirportEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AirportRepository extends JpaRepository<AirportEntity, Integer> {
}
