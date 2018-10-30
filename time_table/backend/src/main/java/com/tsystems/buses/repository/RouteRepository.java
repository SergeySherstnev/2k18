package com.tsystems.buses.repository;

import com.tsystems.buses.model.Route;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface RouteRepository extends CrudRepository<Route, Long> {

    @Query("select r from Route r where r.route_number = ?1")
    List<Route> getRouteByNumber(String route_number);
}
