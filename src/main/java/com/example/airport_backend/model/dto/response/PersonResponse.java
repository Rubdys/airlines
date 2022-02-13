package com.example.airport_backend.model.dto.response;

import lombok.Builder;
import lombok.Getter;
@Getter
@Builder
public class PersonResponse {

    private Integer id;

    private UserResponse user;

    private String firstName;

    private String lastName;

    private String idCard;
}
