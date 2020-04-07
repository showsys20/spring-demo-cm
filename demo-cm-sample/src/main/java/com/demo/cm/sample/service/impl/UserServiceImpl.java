package com.demo.cm.sample.service.impl;

import com.demo.cm.model.User;
import com.demo.cm.sample.annotation.MyLogger;
import com.demo.cm.sample.mapper.UserMapper;
import com.demo.cm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：changxxx
 * @date ：Created at 2020/4/2 23:37
 * @description：
 * @modified By：
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User getUserById(Integer id) {
        return userMapper.getUserById(id);
    }

    @MyLogger(message = "add", fallback = "createUser")
    @Override
    public List<User> getAno(Integer id) {
        List list = new ArrayList();
        list.add(userMapper.getUserById(id));
        return list;
    }

    public User createUser(Integer id) {
        User user = new User();
        user.setId(-1);
        user.setUserName("系统自动创建用户");
        user.setStatus(-1);
        return user;
    }
}
