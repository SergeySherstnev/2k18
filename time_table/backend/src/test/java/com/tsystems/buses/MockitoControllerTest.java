package com.tsystems.buses;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

import com.tsystems.buses.model.Bus;
import com.tsystems.buses.model.Route;
import com.tsystems.buses.repository.RouteRepository;
import com.tsystems.buses.services.Impl.BusServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;


@RunWith(MockitoJUnitRunner.class)
public class MockitoControllerTest {
    @InjectMocks
    private BusServiceImpl busService;

    @Mock
    private RouteRepository routeRepositoryMock;


    @Test
    public void testFindAllRoutes() {
        List<Route> mockRoutes = new ArrayList<Route>();
        List<Bus> mockBuses = new ArrayList<Bus>();

        Route newRoute = new Route("X-00");
        newRoute.setRoute_id(1L);
        Bus newBus1 = new Bus("Ford Sprinter", 1L);
        Bus newBus2 = new Bus("Ford Transit", 2L);
        mockBuses.add(newBus1);
        mockBuses.add(newBus2);
        newRoute.setBuses(mockBuses);
        mockRoutes.add(newRoute);

        when(routeRepositoryMock.getRouteByNumber("X-00")).thenReturn(mockRoutes);
        Route realRoute = busService.findRouteByNumber("X-00");

        verify(routeRepositoryMock).getRouteByNumber("X-00");

        assertEquals(newRoute,realRoute);
    }
}
