package com.example.airport_backend.model.dto.request;

import com.example.airport_backend.model.enums.LuggageType;
import lombok.Getter;

@Getter
public class LuggageRequest {

    private TicketRequest ticket;
    private LuggageType luggageType;
}
