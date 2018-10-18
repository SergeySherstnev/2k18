package com.tsystems.buses.model;

import com.tsystems.buses.model.Bus;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Data
@Entity
@Table(name = "route")
//@NoArgsConstructor
@AllArgsConstructor
public class Route {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
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
