package com.example.airport_backend.controller;

import com.example.airport_backend.model.dto.request.AirportRequest;
import com.example.airport_backend.model.dto.response.AirportResponse;
import com.example.airport_backend.service.AirportService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AirportController {

    private AirportService airportService;

    public AirportController(AirportService airportService) {
        this.airportService = airportService;
    }

    @PostMapping(path = "/airport")
    public AirportResponse addNew(@RequestBody AirportRequest airportRequest){
        return airportService.addNew(airportRequest);
    }

}
