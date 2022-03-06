package com.example.airport_backend.model.dao;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "user")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(unique = true, length = 64)
    private String idCard;

    @Column(unique = true, length = 64)
    private String mail;

    @Column
    private String password;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private WalletEntity wallet;

    @OneToMany(mappedBy = "user")
    private List<TicketEntity> tickets;

    @OneToMany(mappedBy = "user")
    private List<PersonEntity> people;

    @ManyToMany(cascade = CascadeType.PERSIST)
    private List<RoleEntity> roles;

}
