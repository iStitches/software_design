package com.demo.service.impl;

import com.demo.dao.UserMapper;
import com.demo.entity.User;
import com.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("userService")
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;

    @Override
    public User findUserByAccAndPwd(String name, String pwd) {
        return userMapper.getUserByNameAndPwd(name, pwd);
    }

    @Override
    public List<User> findUserList() {
        return userMapper.getAll();
    }
}
