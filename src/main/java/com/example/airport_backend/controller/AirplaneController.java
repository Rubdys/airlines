package com.example.airport_backend.controller;

import com.example.airport_backend.model.dto.request.AirplaneRequest;
import com.example.airport_backend.model.dto.response.AirplaneResponse;
import com.example.airport_backend.service.AirplaneService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AirplaneController {

    private AirplaneService airplaneService;

    public AirplaneController(AirplaneService airplaneService) {
        this.airplaneService = airplaneService;
    }

    @PostMapping(path = "/airplane/add")
    public AirplaneResponse addNew(@RequestBody AirplaneRequest airplaneRequest){
        return airplaneService.addNew(airplaneRequest);
    }

    @GetMapping(path = "/airplane/all")
    public List<AirplaneResponse> getAll(){
        return airplaneService.getAll();
    }

}
