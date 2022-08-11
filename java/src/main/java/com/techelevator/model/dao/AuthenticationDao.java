package com.techelevator.model.dao;

import com.techelevator.model.User;

import java.util.List;

public interface AuthenticationDao {

    List<User> findAll();

    User getUserById(int userId);

    User findByUsername(String username);

    int findIdByUsername(String username);

    boolean create(String username, String password, String role);
}
