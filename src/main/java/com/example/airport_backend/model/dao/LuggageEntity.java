package com.example.airport_backend.model.dao;

import com.example.airport_backend.model.enums.LuggageType;
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
    private Integer id;

    @OneToOne
    private TicketEntity ticket;

    @Column(name = "luggage_type")
    private LuggageType luggageType;
}
