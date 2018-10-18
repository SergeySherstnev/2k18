package com.tsystems.buses.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import com.tsystems.buses.model.*;
import org.apache.log4j.Logger;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.DefaultUriBuilderFactory;

import java.util.Date;
import java.util.List;

@Controller
public class BusController {
    private RestTemplate restTemplate = new RestTemplate();

    private static final Logger logger = Logger.getLogger(BusController.class);

    @Value("${welcome.message}")
    private String message;

    @Value("${error.message}")
    private String errorMessage;

    @GetMapping(value = {"/","/main"})
    public String main(ModelMap modelMap) {
        logger.info("Get main page");

/*        ResponseEntity<List<Route>> response = restTemplate.exchange(
                "http://localhost:8090/allRoutes",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Route>>(){});
        Iterable<Route> allRoutes = response.getBody();

        Iterable<Bus> busesOnRoute = allRoutes.iterator().next().getBuses();
        modelMap.addAttribute("time", new Date());
        modelMap.addAttribute("buses",busesOnRoute);
        modelMap.addAttribute("routes",allRoutes);
        modelMap.addAttribute("message", message);*/
        return "init_page";
    }

    @RequestMapping(value = "/get_routes", method = RequestMethod.GET)
    @ResponseBody
    public Iterable<Route> getRoutes() {
        ResponseEntity<List<Route>> response = restTemplate.exchange(
                "http://localhost:8090/allRoutes",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Route>>(){});
        Iterable<Route> allRoutes = response.getBody();
        return allRoutes;
    }

 /*   @RequestMapping(value = "/select_route", method = RequestMethod.GET)
    @ResponseBody
    public Iterable<Bus> selectRoute(@ModelAttribute ("nameRoute") String nameRoute) {
        Iterable<Bus> busesOnRoute = busService.findBusesOnRoute(nameRoute);
        return busesOnRoute;
    }

    @RequestMapping(value = { "/addBus" }, method = RequestMethod.GET)
    public String showAddBusPage(ModelMap modelMap) {

        Bus newBus = new Bus();
        modelMap.addAttribute("busForm", newBus);

        return "addBus";
    }

    @RequestMapping(value = { "/addBus" }, method = RequestMethod.POST)
    public String saveBus(ModelMap model, //
                             @ModelAttribute("busForm") Bus busForm) {

        String busModel = busForm.getBus_model();
        Long busDriver = busForm.getDriver_id();

        if (busModel != null && busModel.length() > 0 //
                && busDriver != null) {
            Bus newBus = new Bus(busModel, busDriver);
            busService.saveBus(newBus);

            return "redirect:/main";
        }

        model.addAttribute("errorMessage", errorMessage);
        return "addBus";
    }*/


    /*@RequestMapping(name = "/addBus", method = RequestMethod.POST)
    public String  doIt(@ModelAttribute Route route) {
        busService.saveRoute(route);
        return "main";
    }*/
}
