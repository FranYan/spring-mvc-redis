package com.theo.task;

import com.theo.entity.User;
import com.theo.service.UserService;
import com.theo.util.RedisCacheManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Test {

    @Autowired
    private UserService userService;

    @Autowired
    private RedisCacheManager redisCacheManager;

    @Scheduled(cron = "0 */1 * * * ? ")
    public void test(){

        List<User> users = userService.getAll();
        for (User user : users)
            redisCacheManager.set("user"+user.getId().toString(),user);

        System.out.println("缓存完毕！");
    }
}
