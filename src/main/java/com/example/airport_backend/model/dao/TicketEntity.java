package com.example.airport_backend.model.dao;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "ticket")
public class TicketEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ticket_id")
    private Integer ticketId;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;

    @ManyToOne
    @JoinColumn(name = "person_id")
    private PersonEntity person;

    @OneToOne
    private LuggageEntity luggage;

    @ManyToOne
    @JoinColumn(name = "flight_id")
    private FlightEntity flights;

    @ManyToOne
    @JoinColumn(name = "airplane_id")
    private AirplaneEntity airplane;

}
