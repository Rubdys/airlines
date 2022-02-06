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
    private Integer id;

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
