package com.market.server.service;

import com.market.server.model.*;

import java.util.List;

public interface MagazineService {

    Magazine getMagazineById(Long id);
    void saveMagazine(Magazine magazine);
    List<Magazine> getAllMagazines();
    void deleteMagazineById(Long id);
    List<Customer> getCustomersByMagazine(Long id);
}
