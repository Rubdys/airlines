package com.example.airport_backend.repository;

import com.example.airport_backend.model.dao.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Integer> {
}
