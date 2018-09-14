package com.tsystems.dao;

import com.tsystems.model.Place;
import com.tsystems.model.User;

import java.io.Serializable;
import java.util.List;

public interface PlaceDao {

    Serializable savePlace(Place trash);
    List<User> getAllCustomersByMagazin(Place magazine);
}
