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

        //Magazine magazine1 = new Magazine("SPb, Mega-Dybenko");
        //Magazine magazine2 = new Magazine("SPb, Mega-Parnas");
        //magazineService.saveMagazine(magazine1);
        //magazineService.saveMagazine(magazine2);

        //Customer customer1 = new Customer("Vasiliy", 111);
        //Customer customer2 = new Customer("Yaroslav", 444);
        //Customer customer2 = new Customer("Petr", 555);
        //Customer customer3 = new Customer("Yakov", 666);

        //customerService.saveCustomer(customer1, 3L);
        //customerService.saveCustomer(customer2, 3L);
        //customerService.saveCustomer(customer3, 2L);

        AllCustomers_Dybenko = magazineService.getCustomersByMagazine(3L);
        System.out.println(AllCustomers_Dybenko.toString());

        //customerService.saveCustomer();
        //magazineService.deleteMagazineById(1L);
        //magazineService.deleteMagazineById(1L);

    }
}
