package com.tsystems.buses.controller;

import com.tsystems.buses.services.BusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tsystems.buses.model.*;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class BusController {
    @Autowired
    BusService busService;

    @Value("${welcome.message}")
    private String message;

    @Value("${error.message}")
    private String errorMessage;

    @RequestMapping(name = "/", method = RequestMethod.GET)
    public String main(ModelMap modelMap) {
        Iterable<Bus> allBuses = busService.findAllBuses();
         modelMap.addAttribute("buses",busService.findAllBuses());
        return "main";
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
    }


    /*@RequestMapping(name = "/addBus", method = RequestMethod.POST)
    public String  doIt(@ModelAttribute Route route) {
        busService.saveRoute(route);
        return "main";
    }*/
}
