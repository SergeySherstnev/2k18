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
    public void saveCustomer(Customer customer) {
        getSession().saveOrUpdate(customer);
    }

    @Override
    public List<Customer> getAllCustomersByMagazine(Magazine magazine) {
        Criteria criteria = getSession().createCriteria(Customer.class);
        criteria.add(Restrictions.eq("magazine", magazine));
        return criteria.list();
    }
}
