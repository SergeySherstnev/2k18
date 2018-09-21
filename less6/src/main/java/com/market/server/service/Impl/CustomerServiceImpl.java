package com.market.server.service.Impl;

import com.market.server.dao.CustomerDao;
import com.market.server.model.*;
import com.market.server.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    MagazineService magazineService;

    @Autowired
    CustomerDao customerDao;

    @Override
    public void saveCustomer (Customer customer, Long id) {
        Magazine magazineById = magazineService.getMagazineById(id);
        List<Magazine> magazines = new ArrayList<Magazine>();
        magazines.add(magazineById);
        customer.setMagazines(magazines);
        customerDao.saveCustomer(customer);
    }

    @Override
    public void deleteCustomerById(Long id) {
        if (id != null)
            customerDao.deleteCustomer(id);
    }

}
