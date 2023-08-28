package com.demo_230712.controller.login;

import com.demo_230712.bean.Result;
import com.demo_230712.entity.LoginUser;
import com.demo_230712.service.ILoginService;
import com.demo_230712.vo.LoginUserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
//@CrossOrigin
public class LoginUserController {
    @Autowired
    private ILoginService loginService;

    //获取用户列表
    @RequestMapping("/queryUserList")
    @ResponseBody
    public Result queryUserList(@RequestBody LoginUserVo loginUserVo){
        return loginService.queryUserList(loginUserVo);
    }

    //新增用户
    @RequestMapping("/addPeople")
    @ResponseBody
    public Result addPeople(@RequestBody LoginUser loginUser){
        return loginService.addPeople(loginUser);
    }

    //修改用户
    @RequestMapping("/updatePeople")
    @ResponseBody
    public Result updatePeople(@RequestBody LoginUser loginUser){
        return loginService.updatePeople(loginUser);
    }
}
