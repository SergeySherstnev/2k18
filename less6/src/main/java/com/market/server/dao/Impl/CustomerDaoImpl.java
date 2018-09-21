package com.market.server.dao.Impl;

import com.market.server.dao.CustomerDao;
import com.market.server.model.Customer;
import com.market.server.model.Magazine;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Repository
@Transactional
public class CustomerDaoImpl implements CustomerDao {

    @Autowired
    private SessionFactory sessionFactory;

    protected Session getSession() {
        return this.sessionFactory.getCurrentSession();
    }

    @Override
    public Customer getCustomerById(Long id) { return (Customer) getSession().get(Customer.class, id); }

    @Override
    public void saveCustomer(Customer customer) {
        getSession().saveOrUpdate(customer);
    }

    @Override
    public void deleteCustomer(Long id) {
        Customer customer = getCustomerById(id);

        if (customer != null) {
            for (Magazine magazine : customer.getMagazines()) {
                magazine.deleteCustomer(customer);
            }
            getSession().delete(customer);
        }
    }

    @Override
    public List<Customer> getAllCustomersByMagazine(Magazine magazine) {
        /*Criteria criteria = getSession().createCriteria(Customer.class);
        Criteria prdCrit = criteria.createCriteria("magazines");
        //criteria.createAlias("mags", "magazines");
        criteria.add(Restrictions.eq("id", magazine.getId()));
        List<Customer> list = new ArrayList<Customer>();
        list= criteria.list();*/
        return magazine.getCustomers();
    }
}
