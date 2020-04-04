package com.demo.cm.sample.service.impl;

import com.demo.cm.model.User;
import com.demo.cm.sample.mapper.UserMapper;
import com.demo.cm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
