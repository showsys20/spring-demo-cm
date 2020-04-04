package com.demo.cm.sample.controller;

import com.demo.cm.model.User;
import com.demo.cm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
    public User getUser(@RequestParam Integer id) {
        return userService.getUserById(id);
    }

}
