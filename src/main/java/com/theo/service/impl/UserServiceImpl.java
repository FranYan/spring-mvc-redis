package com.theo.service.impl;

import com.theo.dao.UserDao;
import com.theo.entity.User;
import com.theo.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserDao userDao;

    @Override
    public User getUserById(Long id) {

        return userDao.selectById(id);
    }

    @Override
    public void addUser(User user) {
        userDao.insertUser(user);
    }
}
