package com.demo_230712.util;


import com.demo_230712.bean.LoginSession;

/**
 * @author luhongru
 *
 * 这个方法基于拦截器
 * 不经过拦截器的方法LoginSessionPool 中是不存在的
 * 所有LoginSession都通过sessionutil获取，这里不要获取LoginSession
 * 多线程中不要使用该方法获取Session，会导致空指针
 * */
public class LoginSessionPool {
    private static volatile ThreadLocal<LoginSession> loginSessionPool = new ThreadLocal<>();

    /**
     * 获取用户Sesison
     * @param loginSession
     */
    public static void setLoginSessionPool(LoginSession loginSession){
        loginSessionPool.set(loginSession);
    }

    /**
     * 获取用户Session
     * @return
     */
    public static LoginSession getLoginSession(){
        return loginSessionPool.get();
    }
    public static void clear(){
        loginSessionPool.remove();
    }

}
