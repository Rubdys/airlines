package com.example.airport_backend.service;

import com.example.airport_backend.repository.AirportRepository;
import org.springframework.stereotype.Service;

@Service
public class AirportService {

    private AirportRepository airportRepository;

    public AirportService(AirportRepository airportRepository) {
        this.airportRepository = airportRepository;
    }
}
