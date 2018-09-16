package com.tsystems.service.impl;

import com.tsystems.dao.PlaceDao;
import com.tsystems.dao.UserDao;
import com.tsystems.model.Place;
import com.tsystems.model.User;
import com.tsystems.service.PlaceService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class PlaceServiceImpl implements PlaceService {

    @Autowired
    PlaceDao placeDao;

    @Autowired
    UserDao userDao;

    @Override
    public Place getPlaceById(Long id) {
        return placeDao.getPlaceById(id);
    }

    @Override
    public List<User> getUsersByPlace(Long id) {
        Place placeById = getPlaceById(id);
        return userDao.getAllCustomersByMagazine(placeById);
    }

}
