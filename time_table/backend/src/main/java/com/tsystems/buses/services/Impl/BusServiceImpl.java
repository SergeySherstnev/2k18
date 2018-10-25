package com.tsystems.buses.services.Impl;

import com.tsystems.buses.model.Bus;
import com.tsystems.buses.model.Route;
import com.tsystems.buses.repository.*;
import com.tsystems.buses.services.BusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

//@Service
@CrossOrigin
@Controller
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
    @CrossOrigin
    @GetMapping(value = "/allRoutes")
    @ResponseBody
    public Iterable<Route> findAllRoutes() {
        Iterable<Route> all = routeRepository.findAll();
        return all;
    }

    @Override
    public void addBusToRoute(String routeNumber, Bus bus) {
        Route routeByNumber = routeRepository.getRouteByNumber(routeNumber);
        bus.setRoute_id(routeByNumber.getRoute_id());
        busRepository.save(bus);
    }

    @Override
    @GetMapping(value = "/busesOnRoute")
    @ResponseBody
    public Iterable<Bus> findBusesOnRouteId(@ModelAttribute("id") Long routeId) {
        Optional<Route> routeById = routeRepository.findById(routeId);
        if (routeById != null)
            return routeById.get().getBuses();
        else
            return null;
    }

    @Override
    public Iterable<Bus> findBusesOnRoute(@ModelAttribute("Route") String routeNumber) {
        Route routeByNumber = routeRepository.getRouteByNumber(routeNumber);
        if (routeByNumber != null)
            return routeByNumber.getBuses();
        else
            return null;
    }
}
