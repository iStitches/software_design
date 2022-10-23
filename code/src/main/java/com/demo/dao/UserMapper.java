package com.demo.dao;

import com.demo.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {
    int addOne(User user);
    User getUserByNameAndPwd(@Param("name") String name, @Param("pwd") String pwd);
    List<User> getAll();
}
