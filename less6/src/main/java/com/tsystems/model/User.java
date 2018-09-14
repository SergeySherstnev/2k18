package com.tsystems.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@Table(name="user")
public class User {
    @Id
    @Column(name="id")
    private long id;

    @Column(name="name")
    private String name;

    @Column(name="address")
    private String address;

    public User(String userName, String userAddress) {
        this.name = userName;
        this.address = userAddress;
    }

}
