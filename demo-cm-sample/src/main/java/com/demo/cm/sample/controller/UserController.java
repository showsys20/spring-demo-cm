package com.demo.cm.sample.controller;

import com.demo.cm.model.User;
import com.demo.cm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/hello", method = {RequestMethod.GET})
    public List<User> getUser(User user) {
        return userService.getUserByUser(user);
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
        Integer count = 0;
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
