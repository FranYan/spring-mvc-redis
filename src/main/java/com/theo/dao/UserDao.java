package com.theo.dao;

import com.theo.entity.User;

public interface UserDao {

    void insertUser(User user);

    User selectById(Long id);

}
