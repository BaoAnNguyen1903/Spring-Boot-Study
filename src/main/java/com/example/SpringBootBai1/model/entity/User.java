package com.example.SpringBootBai1.model.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class User {
    // uid int auto_increment primary key,
    // name varchar(50),
    // age int,
    // phone varchar(20),
    // email varchar(50),
    // cccd varchar(20),
    // address varchar(100),
    // username varchar(50),
    // password varchar(50),
    // role varchar(1)
    private int uid;
    private String name;
    private int age;
    private String phone;
    private String email;
    private String cccd;
    private String address;
    private String username;
    private String password;
    private String role;
}
