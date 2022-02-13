package com.example.airport_backend.model.dto.request;

import lombok.Getter;

@Getter
public class SeatRequest {

    private Boolean available;
    private String seatNumber;
    private AirplaneRequest airplane;
}
