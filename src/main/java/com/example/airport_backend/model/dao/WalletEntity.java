package com.example.airport_backend.model.dao;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "wallet")

public class WalletEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "wallet_id")
    private Integer walletId;

    @Column(name = "amount")
    private int amount;

    @OneToOne()
    private UserEntity user;
}
