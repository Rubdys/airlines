package com.example.airport_backend.repository;

import com.example.airport_backend.model.dao.AirplaneEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AirplaneRepository extends JpaRepository<AirplaneEntity, Integer> {
}
