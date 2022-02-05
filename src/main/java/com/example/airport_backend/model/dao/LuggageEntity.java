package com.example.airport_backend.model.dao;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "luggage")
public class LuggageEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "luggage_id")
    private Integer luggageId;

    @OneToOne
    private TicketEntity ticketEntity;
}
