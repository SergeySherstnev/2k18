package com.tsystems.service.impl;

import com.tsystems.dao.UserDao;
import com.tsystems.model.Place;
import com.tsystems.model.User;
import com.tsystems.service.PlaceService;
import com.tsystems.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    PlaceService placeService;

    @Autowired
    UserDao userDao;

    @Override
    public void saveUser (User user, Long id) {
        Place placeById = placeService.getPlaceById(id);
        //user.setPlace(placeById);
        userDao.saveUser(user);
    }
}
