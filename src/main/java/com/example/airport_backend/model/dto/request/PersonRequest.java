package com.example.airport_backend.model.dto.request;

import lombok.Getter;

@Getter
public class PersonRequest {

    private UserRequest user;

    private String firstName;

    private String lastName;

    private String idCard;
}
