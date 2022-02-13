package com.example.airport_backend.controller;

import com.example.airport_backend.model.dto.request.TicketRequest;
import com.example.airport_backend.model.dto.response.TicketResponse;
import com.example.airport_backend.service.TicketService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TicketController {

    private TicketService ticketService;

    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    @PostMapping(path = "/tickets/buy")
    public TicketResponse buyTicket(@RequestBody TicketRequest ticketRequest){
        return ticketService.buyTicket(ticketRequest);
    }
}
