package com.market.server.service.Impl;

import com.market.server.dao.CustomerDao;
import com.market.server.model.*;
import com.market.server.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    MagazineService magazineService;

    @Autowired
    CustomerDao customerDao;

    @Override
    public void saveCustomer (Customer customer, Long id) {
        Magazine magazineById = magazineService.getMagazineById(id);
        customer.setMagazine(magazineById);
        customerDao.saveCustomer(customer);
    }

}
