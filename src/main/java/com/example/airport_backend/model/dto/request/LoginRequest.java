package com.example.airport_backend.model.dto.request;

import lombok.Getter;

@Getter
public class LoginRequest {

    private String mail;
    private String password;
}
