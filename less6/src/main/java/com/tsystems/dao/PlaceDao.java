package com.tsystems.dao;

import com.tsystems.model.Place;
import com.tsystems.model.User;

import java.io.Serializable;
import java.util.List;

public interface PlaceDao {

    Place getPlaceById(Long id);
    Serializable savePlace(Place magazine);
    List<User> getAllCustomersByMagazin(Place magazine);
}
