package com.market.server.dao;

import com.market.server.model.*;

import java.util.List;

public interface CustomerDao {

    Customer getCustomerById(Long id);
    void saveCustomer(Customer customer);
    void deleteCustomer(Long id);
    List<Customer> getAllCustomersByMagazine(Magazine magazine);
}
