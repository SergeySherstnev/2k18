package com.tsystems.buses.repository;

import com.tsystems.buses.model.Route;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface RouteRepository extends CrudRepository<Route, Long> {

    @Query("select r from Route r where r.route_number = ?1")
    Route getRouteByNumber(String route_number);
}
