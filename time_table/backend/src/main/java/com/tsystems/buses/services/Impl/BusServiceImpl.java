package com.tsystems.buses.services.Impl;

import com.tsystems.buses.model.Bus;
import com.tsystems.buses.model.Route;
import com.tsystems.buses.repository.*;
import com.tsystems.buses.services.BusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

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
    public void deleteBus(Long id) {
        busRepository.deleteById(id);
    }

    @Override
    public Optional<Bus> findBusById(Long id) {
        Optional<Bus> bus = busRepository.findById(id);
        return bus;
    }

    @Override
    public List<Bus> findAllBuses() {
        List<Bus> targetCollection = new ArrayList<Bus>();
        Iterator<Bus> iterator = (Iterator<Bus>) busRepository.findAll();
        while (iterator.hasNext()) {
            targetCollection.add(iterator.next());
        }
        return targetCollection;
    }

    @Override
    public void saveRoute(Route route) {
        Route savedRoute = routeRepository.save(route);
    }

    @Override
    public void deleteRoute(String routeNumber) {
        Route routeByNumber = routeRepository.getRouteByNumber(routeNumber).get(0);
        if (routeByNumber != null) {
            routeRepository.delete(routeByNumber);
        }
    }

    @Override
    public Route findRouteByNumber(String number) {
        return routeRepository.getRouteByNumber(number).get(0);
    }

    @Override
    public Optional<Route> findRouteById(Long id) {
        return routeRepository.findById(id);
    }

    @Override
    public List<Route> findAllRoutes() {
        List<Route> targetCollection = new ArrayList<Route>();
        Iterable<Route> iterator = routeRepository.findAll();
        for(Route item: iterator) {
            targetCollection.add(item);
        }
        return targetCollection;
    }

    @Override
    public void addBusToRoute(String routeNumber, Bus bus) {
        Route routeByNumber = routeRepository.getRouteByNumber(routeNumber).get(0);
        bus.setRoute_id(routeByNumber.getRoute_id());
        busRepository.save(bus);
    }

    @Override
    public Collection<Bus> findBusesOnRoute(String routeNumber) {
        Route routeByNumber = routeRepository.getRouteByNumber(routeNumber).get(0);
        if (routeByNumber != null)
            return routeByNumber.getBuses();
        else
            return null;
    }
}
