package com.demo_230712.util;


import org.mindrot.jbcrypt.BCrypt;

/**
 * @author luhongru
 * */
public class PassWordUtil {


    /**
     * 检查密码是否正确
     * @param source
     * @param encedPwd
     * @return
     */
    public static boolean  check(String source,String encedPwd){
        return BCrypt.checkpw(source, encedPwd);
    }

}
