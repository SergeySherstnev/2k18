package com.tsystems.buses;

import com.tsystems.buses.model.Bus;
import com.tsystems.buses.model.Route;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class);
    }

//    @Bean
//    public CommandLineRunner demo(BusService busService) {
//        return (args) -> {
//            busService.saveRoute(new Route("K-00"));
//            busService.saveRoute(new Route("596A"));
//            busService.saveRoute(new Route("114"));
//            busService.saveRoute(new Route("18"));
//
//            Bus newBus1 = new Bus("Ford Sprinter", 1L);
//            busService.saveBus(newBus1);
//            busService.addBusToRoute("K-00",newBus1);
//            Bus newBus2 = new Bus("Ford Transit", 2L);
//            busService.saveBus(newBus2);
//            busService.addBusToRoute("K-00",newBus2);
//            Bus newBus3 = new Bus("Mercedes-Benz Citaro", 2L);
//            busService.saveBus(newBus3);
//            busService.addBusToRoute("K-00",newBus3);
//            Bus newBus4 = new Bus("Ikarus-283", 3L);
//            busService.saveBus(newBus4);
//            busService.addBusToRoute("596A",newBus4);
//            Bus newBus5 = new Bus("Ikarus-284", 4L);
//            busService.saveBus(newBus5);
//            busService.addBusToRoute("596A",newBus5);
//            Bus newBus6 = new Bus("Lvovskiy", 5L);
//            busService.saveBus(newBus6);
//            busService.addBusToRoute("114",newBus6);
//
//            for (Bus bus : busService.findAllBuses()) {
//                System.out.println(bus.toString());
//            }
//
//        };
//    }

}
