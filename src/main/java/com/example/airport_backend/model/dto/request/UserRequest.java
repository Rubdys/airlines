package com.example.airport_backend.model.dto.request;

import lombok.Getter;

@Getter
public class UserRequest {

    private String firstName;

    private String lastName;

    private String idCard;

    private String mail;

    private String password;
}
