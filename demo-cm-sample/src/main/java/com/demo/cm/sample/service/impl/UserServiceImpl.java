package com.demo.cm.sample.service.impl;

import com.demo.cm.sample.model.User;
import com.demo.cm.sample.service.UserService;
import org.springframework.stereotype.Service;

/**
 * @author ：changxxx
 * @date ：Created at 2020/4/2 23:37
 * @description：
 * @modified By：
 */
@Service
public class UserServiceImpl implements UserService {

    @Override
    public User getUser() {
        User user = new User();
        user.setId(1);
        user.setName("user1");
        user.setAddress("China");
        return user;
    }
}
