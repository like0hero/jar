package com.demo_230712.service.impl;

import com.demo_230712.bean.LoginSession;
import com.demo_230712.bean.Result;
import com.demo_230712.entity.FileUploadRecord;
import com.demo_230712.entity.LoginUser;
import com.demo_230712.mapper.LoginServiceMapper;
import com.demo_230712.service.ILoginService;
import com.demo_230712.util.DateUtil;
import com.demo_230712.util.RedisUtil;
import com.demo_230712.util.SessionUtil;
import com.demo_230712.vo.LoginUserVo;
import com.demo_230712.vo.UserLoginVO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ILoginServiceImpl implements ILoginService {

    @Resource
    private LoginServiceMapper loginServiceMapper;

    @Resource
    private RedisUtil redisUtil;

    @Override
    public Result login(UserLoginVO vo) {
        //校验用户名和密码是否为空
        if(StringUtils.isBlank(vo.getUserCode()) || StringUtils.isBlank(vo.getPassWord())){
            return Result.error(1001,"账号或密码错误！请重试！");
        }
        //1、校验验证码是否过期
        Result codeResult = checkVCodeTimeOut(vo);
        if(codeResult.getCode() > 0){
            return codeResult;
        }

        //校验账号和密码是否正确
        LoginUser user = loginServiceMapper.getLoginUserInfo(vo.getUserCode());

        if (null == user) return Result.error(1002,"账号或密码错误！请重试");

        if (!user.getStatus().equals("0")) return Result.error(1002,"该账号已被禁用");

        if(!vo.getPassWord().equals(user.getPassword())) return Result.error(1003,"账号或密码错误！请重试");

        LoginSession login = new LoginSession();
        login.setUserCode(user.getUserCode());
        login.setUserName(user.getName());
        login.setLoginDate(new Date());
        //返回sessionId给前台作为TokenId
        String tokenId = SessionUtil.putLoginReturnSessionId(login);
        user.setToken(tokenId);
        return Result.success(user);

    }

    @Override
    public Result queryUserList(LoginUserVo vo) {
        List<LoginUser> loginUsers = loginServiceMapper.queryUserList(vo);
        return Result.success(loginUsers);
    }

    @Override
    public Result addPeople(LoginUser vo) {
        loginServiceMapper.addPeople(vo);
        return Result.success(0);
    }

    @Override
    public Result updatePeople(LoginUser vo) {
        loginServiceMapper.updatePeople(vo);
        return Result.success(0);
    }

    private Result checkVCodeTimeOut(UserLoginVO userLoginVO){
        Result result = new Result();
        String code = redisUtil.get(userLoginVO.getCodeId());
        if(org.springframework.util.StringUtils.isEmpty(code)){
            code = (String) SessionUtil.getSession().getAttribute("Verification_Code");
        }
        //设置验证码失效
        redisUtil.delete(userLoginVO.getCodeId());
        SessionUtil.getSession().removeAttribute("Verification_Code");
        if(!Optional.ofNullable(code).isPresent()){
            result.setCode(1001);
            result.setMsg("验证码失效");
            return result;
        }
        if(code.contains("_")){
            String [] splitVCode = String.valueOf(code).split("_");
            boolean isTimeOut = DateUtil.isTimeOut(Long.valueOf(splitVCode[1]), 300L);
            if(isTimeOut){
                result.setCode(1001);
                result.setMsg("验证码失效");
                return result;
            }
            if(!userLoginVO.getCode().equalsIgnoreCase(splitVCode[0])){
                result.setCode(1002);
                result.setMsg("验证码输入错误");
                return result;
            }
        }else{
            if(!userLoginVO.getCode().equalsIgnoreCase(code)){
                result.setCode(1002);
                result.setMsg("验证码输入错误");
                return result;
            }
        }
        return result;
    }
}
