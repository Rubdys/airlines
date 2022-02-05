package com.example.airport_backend.repository;

import com.example.airport_backend.model.dao.TicketEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.criteria.CriteriaBuilder;

public interface TicketRepository extends JpaRepository<TicketEntity, Integer> {
}
