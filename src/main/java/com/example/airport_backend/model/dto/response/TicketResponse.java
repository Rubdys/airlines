package com.example.airport_backend.model.dto.response;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class TicketResponse {

    private Integer id;

    private UserResponse user;

    private TicketOwnerResponse ticketOwner;

    private LuggageResponse luggage;

    private FlightResponse flight;

    private SeatResponse seat;

}
