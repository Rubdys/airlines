package com.example.airport_backend.model.dao;

import com.example.airport_backend.model.enums.Country;
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
    private Integer id;

    @Column
    private String name;

    @Column
    private Country country;

    @Column
    private String city;

    @OneToMany(mappedBy = "departureAirport")
    private List<FlightEntity> arrivalFlights;

    @OneToMany(mappedBy = "arrivalAirport")
    private List<FlightEntity> departureFlights;
}
