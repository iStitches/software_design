package com.demo.service;

import com.demo.entity.User;

import java.util.List;

public interface UserService {
    User findUserByAccAndPwd(String name, String pwd);
    List<User> findUserList();
}
