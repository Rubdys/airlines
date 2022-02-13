package com.example.airport_backend.model.dto.response;

import com.example.airport_backend.model.enums.LuggageType;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class LuggageResponse {
    private Integer id;

    private TicketResponse ticket;

    private LuggageType luggageType;
}
