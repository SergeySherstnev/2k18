package com.market.server.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

    /*@ManyToOne
    @JoinColumn(name = "magazine_id", referencedColumnName = "id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Magazine magazine;*/
    @ManyToMany(fetch=FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name="magazine_customer", joinColumns = {@JoinColumn(name="customer_id", referencedColumnName="id")},
            inverseJoinColumns = {@JoinColumn(name="magazine_id", referencedColumnName="id")}
    )
    private List<Magazine> magazines;

    public Customer(String userName, int userCard) {
        this.name = userName;
        this.card = userCard;
        this.magazines = new ArrayList<Magazine>();
    }

    public void deleteMagazine(Magazine magazine) {
        magazines.remove(magazine);
        magazine.getCustomers().remove(this);
    }

    public String toString() {
        return "("+id+") " + name + " card = " +card;
    }
}
