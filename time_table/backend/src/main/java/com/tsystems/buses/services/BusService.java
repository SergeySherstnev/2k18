package com.tsystems.buses.services;

import com.tsystems.buses.model.*;

import java.util.Optional;

public interface BusService {

    void saveBus(Bus bus);
    Optional<Bus> findBusById(Long id);
    Iterable<Bus> findAllBuses();

    void saveRoute(Route route);
    Iterable<Route> findAllRoutes();
    void addBusToRoute(String routeNumber, Bus bus);
    Iterable<Bus> findBusesOnRouteId(Long routeId);
    Iterable<Bus> findBusesOnRoute(String routeNumber);
}
