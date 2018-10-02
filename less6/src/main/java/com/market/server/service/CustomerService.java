package com.market.server.service;

import com.market.server.model.Customer;
import com.market.server.model.Magazine;

public interface CustomerService {

    void saveCustomer (Customer customer, Long id);
    void deleteCustomerById(Long id);
}
