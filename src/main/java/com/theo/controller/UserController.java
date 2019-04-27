package com.theo.controller;

import com.theo.entity.User;
import com.theo.service.UserService;
import com.theo.util.Md5;
import com.theo.util.ResultBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.UUID;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/addUser")
    @Transactional(rollbackFor = {Exception.class})
    public ResultBean addUser(@RequestBody User user , HttpServletRequest request){

        String username = user.getUsername();
        String password = user.getPassword();

        String salt = Md5.INSTANCE.getUUID();
        user.setSalt(salt);
        user.setPassword(Md5.INSTANCE.getMd5((password+salt+username).toUpperCase()));
        user.setCreateDate(new Date());

        userService.addUser(user);

        System.out.println(user);

        return new ResultBean(200,user);
    }

    @GetMapping("/getUser/{id}")
    public ResultBean getUser(@PathVariable Long id){

        User user = userService.getUserById(id);

        return new ResultBean(200,user);
    }

}
