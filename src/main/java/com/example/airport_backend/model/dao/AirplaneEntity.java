package com.example.airport_backend.model.dao;

import com.example.airport_backend.model.enums.AirplaneModel;
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
    private Integer id;

    @Column(name = "airplane_model")
    @Enumerated(EnumType.STRING)
    private AirplaneModel airplaneModel;

    @OneToMany(mappedBy = "airplane")
    private List<FlightEntity> flights;

    @OneToMany(mappedBy = "airplane")
    private List<SeatEntity> seats;
}
