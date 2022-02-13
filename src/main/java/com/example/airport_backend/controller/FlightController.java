package com.example.airport_backend.controller;

import com.example.airport_backend.model.dto.request.FlightRequest;
import com.example.airport_backend.model.dto.response.FlightResponse;
import com.example.airport_backend.service.FlightService;
import org.springframework.web.bind.annotation.*;

@RestController
public class FlightController {

    private FlightService flightService;

    public FlightController(FlightService flightService) {
        this.flightService = flightService;
    }

    @PostMapping(path = "/flights/new")
    public FlightResponse addNew(@RequestBody FlightRequest flightRequest){
        return flightService.addNew(flightRequest);
    }

    @GetMapping(path = "/flights/{id}")
    public FlightResponse getById(@PathVariable Integer id){
        return flightService.getById(id);
    }
}
