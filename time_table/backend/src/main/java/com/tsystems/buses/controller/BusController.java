package com.tsystems.buses.controller;

import com.tsystems.buses.model.Bus;
import com.tsystems.buses.model.Route;
import com.tsystems.buses.services.BusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;
import java.util.Optional;


@CrossOrigin
@RestController
//@RequestMapping("/")
public class BusController {

    @Autowired
    BusService busService;

    @GetMapping(value = "/cityRoutes")
    public List<Route> findAllRoutes() {
        List<Route> all = busService.findAllRoutes();
        return all;
    }

//    @GetMapping(value = "/buses")
//    public Iterable<Bus> findBusesOnRouteById(@ModelAttribute("id") String routeNumber) {
    @GetMapping(value = "/buses/{routeNumber}")
    public Collection<Bus> findBusesOnRouteById(@PathVariable String routeNumber) {
        Collection<Bus> busesOnRoute = busService.findBusesOnRoute(routeNumber);
        if (busesOnRoute != null)
            return busesOnRoute;
        else
            throw new NotFoundException();
    }

    @PostMapping(value = "/route")
    public Route addRoute(@RequestBody String routeNumber) {
        Route routeByNumber = busService.findRouteByNumber(routeNumber);
        if (routeByNumber != null){
            return null;
        }
        else {
            Route newRoute = new Route(routeNumber);
            busService.saveRoute(newRoute);
            return newRoute;
        }
    }

    @PutMapping("/route")
    public Route updateRoute(/*@PathVariable Long id,*/ @RequestBody Route route) {
        Optional<Route> routeById = busService.findRouteById(route.getRoute_id());
        if (routeById != null) {
            busService.saveRoute(route);
            return route;
        }
        else {
            return null;
        }
    }

    @DeleteMapping("/route/{routeNumber}")
    public void deleteRoute(@PathVariable String routeNumber) {

        busService.deleteRoute(routeNumber);
    }
}
