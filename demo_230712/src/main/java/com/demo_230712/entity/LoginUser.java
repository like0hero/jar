package com.demo_230712.entity;

import lombok.Data;

import java.util.Date;

@Data
public class LoginUser {

    private Integer id;
    private String userCode;
    private String name;
    private String phone;
    private String status;
    private String password;

    public String token;
}
