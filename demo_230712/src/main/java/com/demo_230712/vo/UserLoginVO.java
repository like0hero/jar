package com.demo_230712.vo;

import lombok.Data;

@Data
public class UserLoginVO {
    /**
     * 账号
     */
    private String userCode;
    /**
     * 密码
     */
    private String passWord;

    /**
     * 验证码
     */
    private String code;
    /**
     * 验证码Id
     */
    private String codeId;

    private String uk;

}
