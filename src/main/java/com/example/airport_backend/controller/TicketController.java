package com.example.airport_backend.controller;

import com.example.airport_backend.service.TicketService;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TicketController {

    private TicketService ticketService;

    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }
}
