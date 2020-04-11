package com.demo.cm.service;


import com.demo.cm.model.User;

import java.util.List;

/**
 * @author ：changxxx
 * @date ：Created at 2020/4/2 23:36
 * @description：
 * @modified By：
 */
public interface UserService {
    User getUserById(Integer id);

    List<User> getUserByUser(User user);

    List<User> getAno(Integer id);

    Integer saveUser(User user);

    Integer saveUserList(List<User> userList);
}
