package com.tsystems.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;


@Entity (name = "market")
@Data
@NoArgsConstructor
@Table
public class Place {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private long id;

    @Column
    private String address;

    @Transient
    private List<User> customer;

    public Place(String userAddress) {
        this.address = userAddress;
    }
}
