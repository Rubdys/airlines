package com.example.airport_backend.service;

import com.example.airport_backend.repository.AirplaneRepository;
import org.springframework.stereotype.Service;

@Service
public class AirplaneService {

    private AirplaneRepository airplaneRepository;

    public AirplaneService(AirplaneRepository airplaneRepository) {
        this.airplaneRepository = airplaneRepository;
    }
}
