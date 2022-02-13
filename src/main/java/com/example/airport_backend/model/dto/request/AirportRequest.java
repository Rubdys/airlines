package com.example.airport_backend.model.dto.request;

import com.example.airport_backend.model.enums.Country;
import lombok.Getter;

@Getter
public class AirportRequest {

    private Integer id;
    private String name;
    private Country country;
    private String city;

}
