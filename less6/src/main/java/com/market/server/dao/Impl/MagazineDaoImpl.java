package com.market.server.dao.Impl;

import com.market.server.dao.MagazineDao;
import com.market.server.model.Magazine;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class MagazineDaoImpl implements MagazineDao {

    @Autowired
    private SessionFactory sessionFactory;

    protected Session getSession() {
        return this.sessionFactory.getCurrentSession();
    }

    @Override
    public Magazine getMagazineById(Long id) { return (Magazine) getSession().get(Magazine.class, id); }

    @Override
    public List<Magazine> getAllMagazines() { return getSession().createCriteria(Magazine.class).list(); }

    @Override
    public void saveMagazine(Magazine magazine) { getSession().saveOrUpdate(magazine); }

    @Override
    public void deleteMagazine(Long id) {
        Magazine magazine = getMagazineById(id);
        if (magazine != null) {
            getSession().delete(magazine);
        }
    }
}
