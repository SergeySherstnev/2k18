package com.market.server;

import com.market.server.config.AppConfig;
import com.market.server.model.*;
import com.market.server.service.*;
import com.market.server.service.Impl.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class App {
    @Autowired
    MagazineService magazineService;

    @Autowired
    CustomerService customerService;

    public static void main(String args[]) {
        //создаем контекст для взаимодействия , т.к. main не может общаться с методами run

        AnnotationConfigApplicationContext ctx =
                new AnnotationConfigApplicationContext(AppConfig.class);

        App app = ctx.getBean(App.class);
        app.run();
    }

    public void run() {

        List<Customer> AllCustomers_Dybenko = new ArrayList<Customer>();

        Magazine magazine1 = new Magazine("SPb, Mega-Dybenko");
        Magazine magazine2 = new Magazine("SPb, Mega-Parnas");
        magazineService.saveMagazine(magazine1);
        magazineService.saveMagazine(magazine2);

        Customer customer1 = new Customer("Vasiliy", 111);
        Customer customer2 = new Customer("Ivan", 222);
        Customer customer3 = new Customer("Aleksey", 333);

        customerService.saveCustomer(customer1, 1L);
        customerService.saveCustomer(customer2, 2L);
        customerService.saveCustomer(customer3, 2L);

        AllCustomers_Dybenko = magazineService.getCustomersByMagazine(2L);
        System.out.println(AllCustomers_Dybenko.toString());
        //magazineService.deleteMagazineById(1L);
    }
}
