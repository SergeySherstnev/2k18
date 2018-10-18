package com.tsystems.buses.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table (name = "bus")
//@NoArgsConstructor
@AllArgsConstructor
public class Bus {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column
    private Long bus_id;

    @Column
    private String bus_model;

    @Column
    private Long route_id;

    /*@ManyToOne (cascade = CascadeType.ALL)
    @JoinColumn(name = "route_id")
    private Route busRoute;*/

    @Column
    private Long driver_id;

    public Bus() {}

    public Bus(String bus_model, Long driver_id) {
        //busRoute = new Route();
        this.bus_model = bus_model;
        this.driver_id = driver_id;
    }
}
