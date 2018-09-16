package com.tsystems.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;


@Entity
@Data
@NoArgsConstructor
@Table (name = "market")
public class Place {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private long id;

    @Column
    private String address;

    @Transient
    private List<User> customer;

    public Place(String magazineAddress) {
        this.address = magazineAddress;
    }
}
