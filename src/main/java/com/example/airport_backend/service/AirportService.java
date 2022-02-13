package com.example.airport_backend.service;

import com.example.airport_backend.model.dao.AirportEntity;
import com.example.airport_backend.model.dto.converter.Converter;
import com.example.airport_backend.model.dto.request.AirportRequest;
import com.example.airport_backend.model.dto.response.AirportResponse;
import com.example.airport_backend.repository.AirportRepository;
import org.springframework.stereotype.Service;

@Service
public class AirportService {

    private AirportRepository airportRepository;
    private Converter converter;

    public AirportService(AirportRepository airportRepository, Converter converter) {
        this.airportRepository = airportRepository;
        this.converter = converter;
    }

    public AirportResponse addNew(AirportRequest airportRequest) {
        return converter.convert(airportRepository.save(converter.convert(airportRequest, AirportEntity.class)), AirportResponse.class);
    }
}
