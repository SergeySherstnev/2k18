package com.tsystems.buses;

import com.tsystems.buses.model.*;
import com.tsystems.buses.repository.BusRepository;
import com.tsystems.buses.repository.RouteRepository;
import com.tsystems.buses.services.BusService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class);
    }

    @Bean
    /*public CommandLineRunner demo(BusRepository bRepository, RouteRepository rRepository) {
        return (args) -> {
            Route defaultRoute = new Route("K-00");
            rRepository.save(defaultRoute);
            bRepository.save(new Bus("Ford Sprinter", 1L));
            bRepository.save(new Bus("Mercedes-Benz Citaro", 2L));
            bRepository.save(new Bus("Ikarus-283", 3L));


            for (Bus bus : bRepository.findAll()) {
                System.out.println(bus.toString());
            }
        };
    }*/
    public CommandLineRunner demo(BusService busService) {
        return (args) -> {
            busService.saveRoute(new Route("K-00"));
            busService.saveBus(new Bus("Ford Sprinter", 1L));
            busService.saveBus(new Bus("Mercedes-Benz Citaro", 2L));
            Bus newBus = new Bus("Ikarus-283", 3L);
            busService.saveBus(newBus);

            busService.addBusToRoute("K-00",newBus);

            for (Bus bus : busService.findAllBuses()) {
                System.out.println(bus.toString());
            }

            System.out.println(busService.findBusesOnRoute("K-01"));
        };
    }

}
