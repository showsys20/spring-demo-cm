package com.demo.cm.sample.controller;

import com.demo.cm.model.User;
import com.demo.cm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author ：changxxx
 * @date ：Created at 2020/4/2 23:33
 * @description：
 * @modified By：
 */
@RestController
public class UserController {
    private static final String USER_KEY = "USER_INFO_";

    @Autowired
    private UserService userService;

    @Autowired
    private RedisTemplate<String, User> redisTemplate;

    @RequestMapping(value = "/hello", method = {RequestMethod.POST, RequestMethod.GET})
    public List<User> getUserList(User user) {
        return userService.getUserByUser(user);
    }

    @RequestMapping(value = "/get", method = {RequestMethod.POST, RequestMethod.GET})
    public User getUser(Integer id) {
        if (id == null || id < 0) {
            return null;
        }
        String key = USER_KEY + id;
        User user = redisTemplate.opsForValue().get(key);
        if (user == null) {
            user = userService.getUserById(id);
            if (user != null) {
                redisTemplate.opsForValue().set(key, user, 30, TimeUnit.MINUTES);
            }
        }
        return user;
    }

    @RequestMapping("/test")
    public String error(Integer id) throws Throwable {
        if (id.equals(1)) {
            throw new RuntimeException("runtime error !!!" + new Date());
        } else {
            throw new Exception("throwable" + new Date());
        }
    }

    @RequestMapping("/ano")
    public List<User> ano(Integer id) {
        return userService.getAno(id);
    }

    //    @RequestMapping("/create")
    public Integer createData(Integer password) {
        if (password != 1024) {
            return 0;
        }
        ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(10,
                20, 1, TimeUnit.MINUTES,
                new ArrayBlockingQueue<Runnable>(100000),
                Executors.defaultThreadFactory(), new ThreadPoolExecutor.CallerRunsPolicy());
        int max = 1000000;
        for (int i = 0; i < max; i++) {
            poolExecutor.execute(() -> {
                Date now = new Date();
                User user = new User();
                user.setStatus(0);
                user.setUserName(UUID.randomUUID().toString().replace("-", ""));
                user.setAddress("");
                user.setCreateTime(now);
                user.setUpdateTime(now);
                userService.saveUser(user);
            });
        }
        return 1;
    }
}
