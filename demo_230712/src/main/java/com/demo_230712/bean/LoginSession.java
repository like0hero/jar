package com.demo_230712.bean;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
public class LoginSession implements Serializable{

    private static final long serialVersionUID = 1L;
    /**
     * 用户ID
     */
    private Integer userId;
    /**
     * 用户账号
     */
    private String userCode;
    /**
     * 用户姓名
     */
    private String userName;

    private String userStatus;

    /**
     * aes key
     */
    private String ak;

    /**
     * 登录时间
     */
    private Date loginDate;

    private Map<String,String> templateMap = new HashMap<>();


    private Map<String,List<String>> permissionGroup = new HashMap<>();


}
