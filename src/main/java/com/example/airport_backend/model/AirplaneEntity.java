package com.example.airport_backend.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "airplane")
public class AirplaneEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "airplane_id")
    private Integer airplaneId;

    @Column(name = "number_of_seats")
    private int numberOfSeats;

    @OneToMany(mappedBy = "airplane")
    private List<FlightEntity> flights;

    @OneToMany(mappedBy = "airplane")
    private List<TicketEntity> tickets;

    @OneToMany(mappedBy = "airplane")
    private List<SeatEntity> seats;
}
