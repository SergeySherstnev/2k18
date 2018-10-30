package com.tsystems.buses;

import com.tsystems.buses.model.*;
import com.tsystems.buses.services.BusService;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Collection;
import java.util.Iterator;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(properties = "application.properties")
public class JUnitTest {

    @Autowired
    BusService busService;

    @Test
    public void InsertionTest() {
        Route route1 = new Route("Z-01");
        Route route2 = new Route("Z-02");
        busService.saveRoute(route1);
        busService.saveRoute(route2);

        Bus bus1 = new Bus("Model-01", 1L);
        Bus bus2 = new Bus("Model-02", 1L);
        Bus bus3 = new Bus("Model-03", 1L);

        busService.saveBus(bus1);
        busService.saveBus(bus2);
        busService.saveBus(bus3);
        busService.addBusToRoute("Z-01",bus1);
        busService.addBusToRoute("Z-01",bus2);
        busService.addBusToRoute("Z-02",bus3);

        Collection<Bus> busesOnRoute1 = busService.findBusesOnRoute("Z-01");
        Assert.assertEquals(2, busesOnRoute1.size());

    }

    @After
    public void DeletionTest() {
        Collection<Bus> busesOnRoute = busService.findBusesOnRoute("Z-01");
        for (Bus bus: busesOnRoute) {
            busService.deleteBus(bus.getBus_id());
        }
        busesOnRoute = busService.findBusesOnRoute("Z-02");
        for (Bus bus: busesOnRoute) {
            busService.deleteBus(bus.getBus_id());
        }
        busService.deleteRoute("Z-01");
        busService.deleteRoute("Z-02");
    }
}
