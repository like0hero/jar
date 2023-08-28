package com.demo_230712.bean;

/**
 *
 * Created by Administrator on 2020/7/28 0028.
 * 数据权限枚举类
 */
public enum AuthorizationEnum {
    DESENSITIZATION("AU001","脱敏权限");

    private String code;

    private String describe;

    AuthorizationEnum(String code, String describe){
        this.code = code;
        this.describe = describe;
    }


    public String getCode() {
        return code;
    }

    public String getDescribe() {
        return describe;
    }
}
