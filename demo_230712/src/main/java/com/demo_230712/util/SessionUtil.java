package com.demo_230712.util;


import com.demo_230712.bean.AuthorizationEnum;
import com.demo_230712.bean.LoginSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * @author luhongru
 * 该类中获取Session和通过Session获取信息的方法不适用于多线程环境下
 * 直接使用会出现空指针问题
 * 需要获取Session中的信息，要把LoginSession当做参数传入线程中
 * */
@Slf4j
public class SessionUtil {
    private static RedisUtil redisUtil = SpringContextUtils.getApplicationContext().getBean(RedisUtil.class);
    /**
     * 用户在session中的key
     */
    public static final String LOGIN_IN_SESSION = "login_session";

    public static HttpSession getSession(){
        return getRequest().getSession();
    }
    /**
     * 获取一个request对象的方法
     *
     * @return HttpServletRequest
     */
    public static HttpServletRequest getRequest() {
        ServletRequestAttributes attrs = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        return (HttpServletRequest) attrs.getRequest();
    }

    public static HttpServletResponse getResponse(){
        ServletRequestAttributes attrs = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        return attrs.getResponse();
    }
    /**
     * 从session中获取到当前用户
     *
     * @return
     */
    public static LoginSession getLoginInfoFromRedis(String userkey) {
        /**
         * 先查询redis ,如果redis响应异常则查询session
         */
        try{
            return redisUtil.hGetToBean(userkey, LOGIN_IN_SESSION, LoginSession.class);
        }catch (Exception e){
            log.debug("*****************redis 异常",e);
        }
        return (LoginSession) getSession().getAttribute(LOGIN_IN_SESSION);
    }
    /**
     * 从session中获取到当前用户
     * 多线程中不要使用该方法获取Session,会导致空指针问题
     * 需要把LoginSession当做参数传入多线程中
     * @return
     */
    public static LoginSession getLoginInfoFromSession() {
        if(null != LoginSessionPool.getLoginSession()){
            return  LoginSessionPool.getLoginSession();
        }
        return (LoginSession) getSession().getAttribute(LOGIN_IN_SESSION);
    }

    /**
     *
     *更新session
     * @return
     */
    public static LoginSession updateLoginInSession(LoginSession login,String uuid) {
        // 直接放入user，顶替掉原来session中的user
        return putLoginIntoSession(login,uuid);
    }

    /**
     * 放入用户session
     * @param login
     * @return
     */
    public static LoginSession putLoginIntoSession(LoginSession login,String uuid){
        try{
            redisUtil.hPutObject(uuid,LOGIN_IN_SESSION,login);
            getSession().setAttribute(LOGIN_IN_SESSION, login);
        }catch (Exception e){
            log.debug("**************redis 异常***********",e);
            getSession().setAttribute(LOGIN_IN_SESSION, login);
        }
        return login;
    }
    /**
     * 放入用户session返回sessionId
     * @param login
     * @return
     */
    public static String putLoginReturnSessionId(LoginSession login){
        String uuId = getUUId();
        try{
            redisUtil.hPutObject(uuId,LOGIN_IN_SESSION,login);
            //setLoginInSessionRedisTimeOut(uuId);
            setLoginInSessionRedisTimeOut(uuId, 30); //存储信息30分钟后失效
            getSession().setAttribute(LOGIN_IN_SESSION, login);
            LoginSessionPool.setLoginSessionPool(login);
            return uuId;
        }catch (Exception e){
            log.debug("*********redis 异常******",e);
            getSession().setAttribute(LOGIN_IN_SESSION, login);
        }
        return getSession().getId();
    }
    /**
     * 放入APP用户session返回sessionId
     * @param login
     * @return
     */
    public static void putAppLoginSession(LoginSession login,String appId){
        try{
            redisUtil.hPutObject(appId,LOGIN_IN_SESSION,login);
            setLoginInSessionRedisTimeOut(appId);
            getSession().setAttribute(LOGIN_IN_SESSION, login);
            LoginSessionPool.setLoginSessionPool(login);
        }catch (Exception e){
            log.debug("*********redis 异常******",e);
            getSession().setAttribute(LOGIN_IN_SESSION, login);
        }
    }

    /**
     * 移除登录信息
     * @return
     */
    public static void removeLoginFromSession(String uuid){
        try{
            redisUtil.hDelete(uuid, LOGIN_IN_SESSION);
        }catch (Exception e){
            log.debug("**********redis 异常",e);
        }
        if(null != getSession().getAttribute(LOGIN_IN_SESSION)){
            getSession().removeAttribute(LOGIN_IN_SESSION);
        }
        LoginSessionPool.clear();
    }

    /**
     *
     * 获取工作量模板Map
     * @return
     */
    public static Map<String,String> getActivitiTemplateMap(String uuid){
        return getLoginInfoFromSession().getTemplateMap();
    }
    /**
     *
     * 获取工作量模板Map
     * @return
     */
    public static Map<String,String> getActivitiTemplateMapForRedis(String uuid){
        return getLoginInfoFromRedis(uuid).getTemplateMap();
    }
    /**
     *
     * 获取工作量模板Map
     * @return
     */
    public static Map<String,String> getActivitiTemplateMap(){
        return getLoginInfoFromSession().getTemplateMap();
    }


    /**
     * 返回对应的模板Code
     * @param var
     * @return
     */
    public static String getActivitiTemplateCode(String var){
        return getActivitiTemplateMap().get(var);
    }
    /**
     * 返回对应的模板Code
     * @param var
     * @return
     */
    public static String getActivitiTemplateCodeFormRedis(String uuid,String var){
        return getActivitiTemplateMap(uuid).get(var);
    }

    /**
     * 生成UUID唯一标识
     * @return
     */
    public static String getUUId(){
        return UUID.randomUUID().toString();
    }

    /**
     * 凌晨清除
     * @param uuid
     */
    public static void setLoginInSessionRedisTimeOut(String uuid){
        Duration duration = Duration.between(LocalDateTime.now(), LocalDate.now().plusDays(1).atTime(0, 0, 0));
        redisUtil.expire(uuid, duration.toMinutes(), TimeUnit.MINUTES);
    }

    public static  void setLoginInSessionRedisTimeOut(String uuid,long timeOut){
        redisUtil.expire(uuid,timeOut, TimeUnit.MINUTES);
    }

    public static boolean existRedis(String uuid){
        return redisUtil.hasKey(uuid);
    }

    public static List<String> getPermissionByGroupCode(AuthorizationEnum authorizationEnum){
        if(null != getLoginInfoFromSession().getPermissionGroup() && !"".equals(getLoginInfoFromSession().getPermissionGroup())){
            return getLoginInfoFromSession().getPermissionGroup().get(authorizationEnum.getCode());
        }
        return null;
    }

}
