package com.tsystems.dao.impl;

import com.tsystems.dao.PlaceDao;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.tsystems.model.*;
import java.io.Serializable;
import java.util.List;

@Repository
@Transactional
public class PlaceDaoImpl implements PlaceDao {

    @Autowired
    private SessionFactory sessionFactory;

    protected Session getSession(){
        return this.sessionFactory.getCurrentSession();
    }

    @Override
    public Place getPlaceById (Long id) {
        return (Place) getSession().get(Place.class, id);
    }

    @Override
    public Serializable savePlace(Place place) {
        return getSession().save(place);
    }

    @Override
    public List<User> getAllCustomersByMagazin(Place magazine){
        Criteria criteria = getSession().createCriteria(User.class);
        criteria.add(Restrictions.eq("magazine", magazine));
        return criteria.list();
    }
}
