package com.example.airport_backend.repository;

import com.example.airport_backend.model.dao.TicketEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TicketRepository extends JpaRepository<TicketEntity, Integer> {

    @Query("SELECT t FROM TicketEntity t where t.flight.id = ?1")
    List<TicketEntity> findByFlightID(Integer flightId);
}
