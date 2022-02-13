package com.example.airport_backend.service;

import com.example.airport_backend.exception.ApplicationError;
import com.example.airport_backend.exception.ApplicationException;
import com.example.airport_backend.model.dao.*;
import com.example.airport_backend.model.dto.converter.Converter;
import com.example.airport_backend.model.dto.request.TicketRequest;
import com.example.airport_backend.model.dto.response.TicketOwnerResponse;
import com.example.airport_backend.model.dto.response.TicketResponse;
import com.example.airport_backend.model.dto.response.UserResponse;
import com.example.airport_backend.repository.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TicketService {

    private TicketRepository ticketRepository;
    private UserRepository userRepository;
    private FlightRepository flightRepository;
    private Converter converter;
    private TicketOwnerRepository ticketOwnerRepository;
    //TODO SEAT


    public TicketService(TicketRepository ticketRepository, UserRepository userRepository, FlightRepository flightRepository, Converter converter, TicketOwnerRepository ticketOwnerRepository) {
        this.ticketRepository = ticketRepository;
        this.userRepository = userRepository;
        this.flightRepository = flightRepository;
        this.converter = converter;
        this.ticketOwnerRepository = ticketOwnerRepository;
    }

    public TicketResponse buyTicket(TicketRequest ticketRequest) {
        TicketEntity toAdd = new TicketEntity();
        toAdd.setUser(converter.convert(userRepository.findByMail(ticketRequest.getUser().getMail())
                .orElseThrow(() -> new ApplicationException(ApplicationError.NOT_FOUND)), UserEntity.class));

        Optional<TicketOwnerEntity> ticketOwnerEntity = ticketOwnerRepository.findByIdCard(ticketRequest.getTicketOwner().getIdCard());

        if(ticketOwnerEntity.isPresent()){
            toAdd.setTicketOwner(ticketOwnerEntity.get());
        } else{
            toAdd.setTicketOwner(converter.convert(ticketRequest.getTicketOwner(), TicketOwnerEntity.class));
        }

        toAdd.setLuggage(converter.convert(ticketRequest.getLuggage(), LuggageEntity.class));
        //TODO toAdd.setSeat();

        toAdd.setFlight(flightRepository.findById(ticketRequest.getFlight().getId()).orElseThrow(() -> new ApplicationException(ApplicationError.NOT_FOUND)));

        return converter.convert(ticketRepository.save(toAdd), TicketResponse.class);
    }
}
