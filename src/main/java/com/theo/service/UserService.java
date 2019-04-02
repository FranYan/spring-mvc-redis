package com.theo.service;

import com.theo.entity.User;

import java.util.List;

public interface UserService {

    User getUserById(Long id);

    void addUser(User user);

    List<User> getAll();

}
