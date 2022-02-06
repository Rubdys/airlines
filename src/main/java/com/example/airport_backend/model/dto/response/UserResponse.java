package com.example.airport_backend.model.dto.response;


import lombok.Builder;
import lombok.Setter;

@Setter
@Builder
public class UserResponse {

    private Integer id;

    private String firstName;

    private String lastName;

    private String idCard;

    private String mail;
}
