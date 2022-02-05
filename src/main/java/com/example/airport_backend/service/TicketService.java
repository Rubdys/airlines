package com.example.airport_backend.service;

import com.example.airport_backend.repository.TicketRepository;
import org.springframework.stereotype.Service;

@Service
public class TicketService {

    private TicketRepository ticketRepository;

    public TicketService(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }
}