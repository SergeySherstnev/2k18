package com.tsystems.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@Table (name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column
    private String name;

    @Column
    private int card;

    @ManyToOne
    private Place market;

    public User(String userName, int userCard) {
        this.name = userName;
        this.card = userCard;
    }

}
