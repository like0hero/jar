package com.demo_230712.handler;

import com.demo_230712.bean.Result;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
@RestControllerAdvice  //拦截所有带有Controller注解的控制器
public class ControllerExceptionHandler {

    //该方法可以做异常处理
    @ExceptionHandler(RuntimeException.class)
    public Result exceptionHander(RuntimeException re){
        Result result = new Result();
        result.setCode(500);
        result.setMsg("系统运行时异常,请联系管理员!");
        System.out.println(re);
        return result;
    }
}
