package com.market.server.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table (name = "customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column
    private String name;

    @Column
    private int card;

    @ManyToOne
    @JoinColumn(name = "magazine_id", referencedColumnName = "id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Magazine magazine;

    public Customer(String userName, int userCard) {
        this.name = userName;
        this.card = userCard;
    }
}
