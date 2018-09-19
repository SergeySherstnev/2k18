package com.market.test;

import com.market.server.model.Customer;
import com.market.server.model.Magazine;
import com.market.server.service.CustomerService;
import com.market.server.service.MagazineService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:app.xml"})

public class CustomerServiceTest {
    @Autowired
    MagazineService magazineService;

    @Autowired
    CustomerService customerService;

    @Test
    public void insertionTest() {
        List<Customer> AllCustomers_Parnas = new ArrayList<Customer>();

        Magazine magazine1 = new Magazine("SPb, Mega-Dybenko");
        Magazine magazine2 = new Magazine("SPb, Mega-Parnas");
        magazineService.saveMagazine(magazine1);
        magazineService.saveMagazine(magazine2);
        Long id1 = magazine1.getId();
        Long id2 = magazine2.getId();

        Customer customer1 = new Customer("Vasiliy", 111);
        Customer customer2 = new Customer("Ivan", 222);
        Customer customer3 = new Customer("Aleksey", 333);

        customerService.saveCustomer(customer1, id1);
        customerService.saveCustomer(customer2, id2);
        customerService.saveCustomer(customer3, id2);

        AllCustomers_Parnas = magazineService.getCustomersByMagazine(id2);
        Assert.assertEquals(2, AllCustomers_Parnas.size());

        magazineService.deleteMagazineById(1L);
        magazineService.deleteMagazineById(2L);
    }

}
