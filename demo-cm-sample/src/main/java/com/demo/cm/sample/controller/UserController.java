package com.demo.cm.sample.controller;

import com.demo.cm.model.User;
import com.demo.cm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

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

    @RequestMapping("/test")
    public String error(Integer id) throws Throwable {
        if (id.equals(1)) {
            throw new RuntimeException("runtime error !!!" + new Date());
        } else {
            throw new Exception("throwable" + new Date());
        }
    }

    @RequestMapping("/ano")
    public List<User> ano(Integer id) throws Throwable {
        return userService.getAno(id);
    }
}
