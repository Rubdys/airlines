package com.example.airport_backend.service;

import com.example.airport_backend.exception.ApplicationError;
import com.example.airport_backend.exception.ApplicationException;
import com.example.airport_backend.model.dao.AirplaneEntity;
import com.example.airport_backend.model.dao.AirportEntity;
import com.example.airport_backend.model.dao.FlightEntity;
import com.example.airport_backend.model.dao.TicketEntity;
import com.example.airport_backend.model.dto.converter.Converter;
import com.example.airport_backend.model.dto.request.FlightRequest;
import com.example.airport_backend.model.dto.response.*;
import com.example.airport_backend.repository.AirplaneRepository;
import com.example.airport_backend.repository.AirportRepository;
import com.example.airport_backend.repository.FlightRepository;
import com.example.airport_backend.repository.TicketRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class FlightService {
    private FlightRepository flightRepository;
    private AirplaneRepository airplaneRepository;
    private AirportRepository airportRepository;
    private TicketRepository ticketRepository;
    private Converter converter;

    public FlightService(FlightRepository flightRepository, AirplaneRepository airplaneRepository, AirportRepository airportRepository, Converter converter, TicketRepository ticketRepository) {
        this.flightRepository = flightRepository;
        this.airplaneRepository = airplaneRepository;
        this.airportRepository = airportRepository;
        this.converter = converter;
        this.ticketRepository = ticketRepository;
    }

    public FlightResponse addNew(FlightRequest flightRequest) {
        FlightEntity toAdd = converter.convert(flightRequest, FlightEntity.class);

        Optional<AirplaneEntity> airplane = airplaneRepository.findById(flightRequest.getAirplane().getId());
        Optional<AirportEntity> departureAirport = airportRepository.findById(flightRequest.getDepartureAirport().getId());
        Optional<AirportEntity> arrivalAirport = airportRepository.findById(flightRequest.getArrivalAirport().getId());

        if(airplane.isPresent() && departureAirport.isPresent() && arrivalAirport.isPresent()){
            toAdd.setAirplane(airplane.get());
            toAdd.setDepartureAirport(departureAirport.get());
            toAdd.setArrivalAirport(arrivalAirport.get());
            return converter.convert(flightRepository.save(toAdd), FlightResponse.class);
        } else{
            throw new ApplicationException(ApplicationError.MISSING_FIELDS);
        }
    }

    public FlightResponse getById(Integer id) {
        FlightEntity found = flightRepository.findById(id).orElseThrow(() -> new ApplicationException(ApplicationError.NOT_FOUND));

        FlightResponse toReturn = converter.convert(found, FlightResponse.class);

        //Creating ticket list for FlightResponse
        List<TicketEntity> ticketsEntity = ticketRepository.findByFlightID(found.getId());
        List<TicketResponse> ticketsResponse = new ArrayList<>();
        if(!ticketsEntity.isEmpty()) {
            ticketsEntity.forEach(x -> ticketsResponse.add(
                    TicketResponse.builder()
                            .id(x.getId())
                            .luggage(converter.convert(x.getLuggage(), LuggageResponse.class))
                            .seat(converter.convert(x.getSeat(), SeatResponse.class))
                            .user(converter.convert(x.getUser(), UserResponse.class))
                            .ticketOwner(converter.convert(x.getTicketOwner(), TicketOwnerResponse.class))
                            .build()
            ));
        }

        //Creating departure Airport for FlightResponse
        AirportEntity departureAirportEntity = found.getDepartureAirport();
        AirportResponse departureAirportResponse = converter.convert(departureAirportEntity, AirportResponse.class);

        //Creating arrival Airport for FlightResponse
        AirportEntity arrivalAirportEntity = found.getArrivalAirport();
        AirportResponse arrivalAirportResponse = converter.convert(arrivalAirportEntity, AirportResponse.class);

        //Creating airplane for FlightResponse
        AirplaneEntity airplaneEntity = found.getAirplane();
        AirplaneResponse airplaneResponse = converter.convert(airplaneEntity, AirplaneResponse.class);

        //Creating FlightResponse
        toReturn.setTickets(ticketsResponse);
        toReturn.setDepartureAirport(departureAirportResponse);
        toReturn.setArrivalAirport(arrivalAirportResponse);
        toReturn.setAirplane(airplaneResponse);

        return toReturn;
    }
}
