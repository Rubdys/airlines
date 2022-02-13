package com.example.airport_backend.model.dto.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Setter
@Getter
@Builder
public class FlightResponse {
    private Integer id;

    private List<TicketResponse> tickets;

    private LocalDateTime departureTime;

    private LocalDateTime arrivalTime;

    private AirportResponse departureAirport;

    private AirportResponse arrivalAirport;

    private AirplaneResponse airplane;

}
