package com.theo.service.impl;

import com.theo.dao.UserDao;
import com.theo.entity.User;
import com.theo.service.UserService;
import com.theo.util.RedisCacheManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserDao userDao;

    @Autowired
    private RedisCacheManager redisCacheManager;

    @Override
    public User getUserById(Long id) {

        Object user =  redisCacheManager.get("user"+id.toString());
        if (user == null){
            redisCacheManager.set("user"+id.toString(),userDao.selectById(id),60);
            user =  redisCacheManager.get("user"+id.toString());
        }

        return (User) user;
    }

    @Override
    public void addUser(User user) {
        userDao.insertUser(user);
    }

    @Override
    public List<User> getAll() {
        return userDao.selectAll();
    }
}
