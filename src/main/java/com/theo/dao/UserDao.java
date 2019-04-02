package com.theo.dao;

import com.theo.entity.User;

import java.util.List;

public interface UserDao {

    void insertUser(User user);

    User selectById(Long id);

    List<User> selectAll();

}
