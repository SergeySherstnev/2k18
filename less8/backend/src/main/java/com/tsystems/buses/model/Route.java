package com.tsystems.buses.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

@Data
@Entity
@Table(name = "route")
//@NoArgsConstructor
@AllArgsConstructor
public class Route {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column
    private Long route_id;

    @Column
    private String route_number;

    @OneToMany(mappedBy = "route_id", fetch = FetchType.EAGER)
    private Collection<Bus> buses = new ArrayList<>();

    public Route() {}

    public Route(String route_number) {
        buses=null;
        this.route_number = route_number;
    }
}
