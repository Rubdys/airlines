package com.example.airport_backend.model.dto.request;

import lombok.Getter;

@Getter
public class TicketOwnerRequest {

    private TicketRequest ticket;

    private String firstName;

    private String lastName;

    private String idCard;
}
