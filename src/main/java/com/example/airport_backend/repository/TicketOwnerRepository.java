package com.example.airport_backend.repository;

import com.example.airport_backend.model.dao.TicketOwnerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TicketOwnerRepository extends JpaRepository<TicketOwnerEntity, Integer> {
    Optional<TicketOwnerEntity> findByIdCard(String idCard);
}
