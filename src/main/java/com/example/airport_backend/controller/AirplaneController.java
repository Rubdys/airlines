package com.example.airport_backend.controller;

import com.example.airport_backend.service.AirplaneService;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AirplaneController {

    private AirplaneService airplaneService;

    public AirplaneController(AirplaneService airplaneService) {
        this.airplaneService = airplaneService;
    }
}
