package com.tsystems.dao;

import com.tsystems.model.*;
import java.io.Serializable;
import java.util.List;

public interface UserDao {
    Serializable saveUser(User user);
    User getUserById(Long id);
    void deleteUser(Long id);
    List<User> getAll();
}
