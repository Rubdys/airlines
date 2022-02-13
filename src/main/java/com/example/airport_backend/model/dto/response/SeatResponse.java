package com.example.airport_backend.model.dto.response;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class SeatResponse {

    private Integer id;

    private boolean available;

    private String seatNumber;

    private AirplaneResponse airplane;

    private List<TicketResponse> tickets;
}
