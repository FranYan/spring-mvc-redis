package com.theo.service;

import com.theo.entity.User;

public interface UserService {

    User getUserById(Long id);

    void addUser(User user);

}
