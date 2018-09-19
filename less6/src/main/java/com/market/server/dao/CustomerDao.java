package com.market.server.dao;

import com.market.server.model.*;

import java.util.List;

public interface CustomerDao {

    void saveCustomer(Customer customer);
    List<Customer> getAllCustomersByMagazine(Magazine magazine);
}
