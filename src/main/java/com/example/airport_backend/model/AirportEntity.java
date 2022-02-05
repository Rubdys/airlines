package com.example.airport_backend.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "airport")
public class AirportEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "airport_id")
    int airportId;

    @Column
    String name;

    @Column
    String country;

    @Column
    String city;

    @OneToMany(mappedBy = "departureAirport")
    private List<FlightEntity> arrivalFlights;

    @OneToMany(mappedBy = "arrivalAirport")
    private List<FlightEntity> departureFlights;
}
