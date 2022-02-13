package com.example.airport_backend.model.dto.response;

import com.example.airport_backend.model.dto.request.TicketRequest;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class TicketOwnerResponse {
    private Integer id;

    private TicketRequest ticket;

    private String firstName;

    private String lastName;

    private String idCard;
}
