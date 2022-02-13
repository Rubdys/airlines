package com.example.airport_backend.model.dto.request;

import lombok.Getter;

@Getter
public class TicketRequest {

    private UserRequest user;

    private TicketOwnerRequest ticketOwner;

    private LuggageRequest luggage;

    private FlightRequest flight;

    private SeatRequest seat;
}
