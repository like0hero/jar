package com.demo_230712.filter;

import com.alibaba.fastjson.JSON;
import com.demo_230712.bean.Result;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class InterceptorFilter extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o){
        String token = request.getHeader("token");
        if(StringUtils.isEmpty(token)){
            reqInfo(response, Result.error(500, "请登录系统再进行操作"));
            return false;
        }
        return true;
    }

    private void reqInfo(HttpServletResponse response, Object responseObject) {
        response.setContentType("application/json; charset=utf-8");
        response.setCharacterEncoding("UTF-8");
        String jsonStr = JSON.toJSONString(responseObject);
        try (PrintWriter out = response.getWriter()) {
            out.append(jsonStr);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView){
    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e){
    }
}
