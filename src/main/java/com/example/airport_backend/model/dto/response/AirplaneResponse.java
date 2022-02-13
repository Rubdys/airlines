package com.example.airport_backend.model.dto.response;


import com.example.airport_backend.model.enums.AirplaneModel;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class AirplaneResponse {

    private Integer id;
    private AirplaneModel airplaneModel;

    private List<FlightResponse> flights;

    private List<TicketResponse> tickets;

    private List<SeatResponse> seats;

}
