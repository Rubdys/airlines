package com.example.airport_backend.service;

import com.example.airport_backend.model.dao.AirplaneEntity;
import com.example.airport_backend.model.dto.converter.Converter;
import com.example.airport_backend.model.dto.request.AirplaneRequest;
import com.example.airport_backend.model.dto.response.AirplaneResponse;
import com.example.airport_backend.repository.AirplaneRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AirplaneService {

    private AirplaneRepository airplaneRepository;
    private Converter converter;

    public AirplaneService(AirplaneRepository airplaneRepository, Converter converter) {
        this.airplaneRepository = airplaneRepository;
        this.converter = converter;
    }

    public AirplaneResponse addNew(AirplaneRequest airplaneRequest) {
        return converter.convert(airplaneRepository.save(converter.convert(airplaneRequest, AirplaneEntity.class)), AirplaneResponse.class);
    }

    public List<AirplaneResponse> getAll() {
        return converter.convert(airplaneRepository.findAll(), AirplaneResponse.class);
    }
}
