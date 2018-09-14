package com.tsystems.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.tsystems.model.*;
import java.io.Serializable;
import java.util.List;

@Repository
@Transactional
public class UserDaoImpl implements UserDao{
    @Autowired
    private SessionFactory sessionFactory;

    protected Session getSession(){
        return this.sessionFactory.getCurrentSession();
    }

    @Override
    public Serializable saveUser(User user) {
        return getSession().save(user);
    }

    @Override
    public User getUserById(Long id) {
        return (User) getSession().get(User.class,id);
    }

    @Override
    public void deleteUser(Long id) {
        if(id != null){
            User userById = getUserById(id);
            getSession().delete(userById);
        }
    }

    @Override
    public List<User> getAll() {
        return getSession().createCriteria(User.class).list();
    }
}
