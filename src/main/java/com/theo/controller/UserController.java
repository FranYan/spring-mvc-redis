package com.theo.controller;

import com.theo.entity.User;
import com.theo.service.UserService;
import com.theo.util.Md5;
import com.theo.util.ResultBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.UUID;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/addUser")
    public ResultBean addUser(@RequestBody User user , HttpServletRequest request){

        String username = user.getUsername();
        String password = user.getPassword();

        String salt = UUID.randomUUID().toString();
        user.setSalt(salt);
        user.setPassword(Md5.INSTANCE.getMd5((password+salt+username).toUpperCase()));
        user.setCreateDate(new Date());

        userService.addUser(user);

        System.out.println(user);

        return new ResultBean(200,user);
    }

}
