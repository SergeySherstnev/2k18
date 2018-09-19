package com.market.server.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "market")
public class Magazine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private long id;

    @Column
    private String address;

    //@OneToMany(mappedBy = "magazine", cascade = CascadeType.ALL, orphanRemoval = true)
    @Transient
    private List<Customer> customers;

    public Magazine(String magazineAddress) {
        this.address = magazineAddress;
        this.customers = new ArrayList<Customer>();
    }

    /*public Long getId() { return id; }

    public Magazine(String magazineAddress) {
        this.address = magazineAddress;
        this.customers = new ArrayList<Customer>();
    }

    public void addCustomer(Customer customer) {
        customer.setMagazine(this);
        customers.add(customer);
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(List<Customer> users) {
        this.customers = users;
    }*/
}
