package com.tsystems.buses.services.Impl;

import com.tsystems.buses.model.Bus;
import com.tsystems.buses.model.Route;
import com.tsystems.buses.repository.*;
import com.tsystems.buses.services.BusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Optional;

@Service
public class BusServiceImpl implements BusService {
    @Autowired
    BusRepository busRepository;
    @Autowired
    RouteRepository routeRepository;

    @Override
    public void saveBus(Bus bus) {
        busRepository.save(bus);
    }

    @Override
    public Optional<Bus> findBusById(Long id) {
        Optional<Bus> byId = busRepository.findById(id);
        return byId;
    }

    @Override
    public Iterable<Bus> findAllBuses() {
        Iterable<Bus> all = busRepository.findAll();
        return all;
    }

    @Override
    public void saveRoute(Route route) {
        Route savedRoute = routeRepository.save(route);
    }

    @Override
    public void addBusToRoute(String routeNumber, Bus bus) {
        Route routeByNumber = routeRepository.getRouteByNumber(routeNumber);
        bus.setRoute_id(routeByNumber.getRoute_id());
        busRepository.save(bus);
    }

    @Override
    public Iterable<Bus> findBusesOnRoute(String routeNumber) {
        Route routeByNumber = routeRepository.getRouteByNumber(routeNumber);
        if (routeByNumber != null)
            return routeByNumber.getBuses();
        else
            return null;
    }
}
