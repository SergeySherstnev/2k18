package com.market.server.service.Impl;

import com.market.server.dao.*;
import com.market.server.model.*;
import com.market.server.service.MagazineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MagazineServiceImpl implements MagazineService {

    @Autowired
    MagazineDao magazineDao;

    @Autowired
    CustomerDao customerDao;

    @Override
    public Magazine getMagazineById(Long id) { return magazineDao.getMagazineById(id); }

    @Override
    public void saveMagazine(Magazine magazine) {
        /*if (magazine.getCustomers() != null) {
            List<Customer> allCustomersByMagazine = customerDao.getAllCustomersByMagazine(magazine);
            for (Customer customer : allCustomersByMagazine) {
                customer.setMagazine(magazine);
                customerDao.saveCustomer(customer);
            }
        }*/
        magazineDao.saveMagazine(magazine);
    }

    @Override
    public List<Magazine> getAllMagazines() { return magazineDao.getAllMagazines(); }

    @Override
    public void deleteMagazineById(Long id) {
        if (id != null)
            magazineDao.deleteMagazine(id);
    }

    @Override
    public List<Customer> getCustomersByMagazine(Long id) {
        Magazine magazineById = getMagazineById(id);
        return customerDao.getAllCustomersByMagazine(magazineById);
    }
}
