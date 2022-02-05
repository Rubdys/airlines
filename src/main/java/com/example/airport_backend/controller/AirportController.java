package com.example.airport_backend.controller;

import com.example.airport_backend.service.AirportService;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AirportController {

    private AirportService airportService;

    public AirportController(AirportService airportService) {
        this.airportService = airportService;
    }
}
