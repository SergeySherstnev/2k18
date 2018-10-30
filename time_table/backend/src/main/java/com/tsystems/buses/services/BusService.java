package com.tsystems.buses.services;

import com.tsystems.buses.model.*;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface BusService {

    void saveBus(Bus bus);
    void deleteBus (Long id);
    Optional<Bus> findBusById(Long id);
    List<Bus> findAllBuses();

    void saveRoute(Route route);
    void deleteRoute (String routeNumber);
    Route findRouteByNumber(String number);
    Optional<Route> findRouteById(Long id);
    List<Route> findAllRoutes();
    void addBusToRoute(String routeNumber, Bus bus);
//    Iterable<Bus> findBusesOnRouteId(Long routeId);
    Collection<Bus> findBusesOnRoute(String routeNumber);
}
