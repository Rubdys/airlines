package com.example.airport_backend.model.dto.response;

import com.example.airport_backend.model.dao.FlightEntity;
import com.example.airport_backend.model.enums.Country;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.OneToMany;
import java.util.List;

@Getter
@Builder
public class AirportResponse {

    private Integer id;
    private String name;
    private Country country;
    private String city;

    private List<FlightResponse> arrivalFlights;

    private List<FlightResponse> departureFlights;

}
