package com.demo_230712.service;

import com.demo_230712.bean.Result;
import com.demo_230712.entity.FileUploadRecord;
import com.demo_230712.entity.LoginUser;
import com.demo_230712.vo.LoginUserVo;
import com.demo_230712.vo.UserLoginVO;


public interface ILoginService {

    //登录
    Result login(UserLoginVO vo);

    //通过查询条件查询数据
    Result queryUserList(LoginUserVo vo);

    Result addPeople(LoginUser vo);

    Result updatePeople(LoginUser vo);

}
