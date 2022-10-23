package com.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    int id;
    String name;
    String password;
    boolean sex;
    String department;

    public User(String name, String password, boolean sex, String department) {
        this.name = name;
        this.password = password;
        this.sex = sex;
        this.department = department;
    }
}
