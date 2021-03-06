package com.example.airport_backend.model.dto.response;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Builder
public class UserResponse {

    private Integer id;

    private String firstName;

    private String lastName;

    private String idCard;

    private String mail;

    private List<TicketResponse> tickets;
}
