package com.example.airport_backend.model.dto.request;

import com.example.airport_backend.model.enums.AirplaneModel;
import lombok.Getter;

@Getter
public class AirplaneRequest {

    private Integer id;

    private AirplaneModel airplaneModel;

}
