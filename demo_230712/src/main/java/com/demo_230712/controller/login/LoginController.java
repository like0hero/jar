package com.demo_230712.controller.login;

import com.demo_230712.bean.Result;
import com.demo_230712.service.ILoginService;
import com.demo_230712.util.RedisUtil;
import com.demo_230712.util.SessionUtil;
import com.demo_230712.util.VerifyCodeUtils;
import com.demo_230712.vo.UserLoginVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@Controller
//@CrossOrigin
@Slf4j
public class LoginController {

    @Autowired
    private ILoginService loginService;

    @Resource
    private RedisUtil redisUtil;

    @RequestMapping("/login")
    @ResponseBody
    public Result login(@RequestBody UserLoginVO vo){
        return loginService.login(vo);
    }

    @RequestMapping("/verificationCode")
    @ResponseBody
    public Result getVerificationCode() throws IOException {
        Result<Map<String,Object>> result = new Result<>();
        Map<String,Object> dataMap = new HashMap<>();
        //1、获取验证码
        String vCode = VerifyCodeUtils.generateVerifyCode(4);
        //2、放入Session，考虑验证码失效时间
        String uuid = setVCode(vCode);
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        //验证码生成大小
        VerifyCodeUtils.outputImage(99, 38, output, vCode);
        String imgStr = Base64.getEncoder().encodeToString(output.toByteArray());
        //3、返回给前台
        dataMap.put("vCodeIO",imgStr);
        dataMap.put("vCodeId",uuid);
        result.setData(dataMap);
        return result;
    }

    public String setVCode(String vCode){
        //验证码生成格式 验证码_时间戳，失效时间5分钟
        SessionUtil.getSession().setAttribute("Verification_Code",vCode + "_" + System.currentTimeMillis());
        //并且放入redis
        String uuId = SessionUtil.getUUId();
        redisUtil.delete(uuId);
        try{
            redisUtil.set(uuId,vCode);
            redisUtil.expire(uuId, 5, TimeUnit.MINUTES);
        }catch (RuntimeException ru){
            log.info("***************redis 异常************",ru);
        }
        return uuId;
    }
}
