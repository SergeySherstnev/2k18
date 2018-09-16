package com.tsystems.service;

import com.tsystems.model.Place;
import com.tsystems.model.User;

import java.util.List;

public interface PlaceService {
    Place getPlaceById(Long id);

    List<User> getUsersByPlace(Long id);
}
