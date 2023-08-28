package com.demo_230712.mapper;

import com.demo_230712.entity.FileUploadRecord;
import com.demo_230712.entity.LoginUser;
import com.demo_230712.vo.LoginUserVo;

import java.util.List;

public interface LoginServiceMapper {
    public LoginUser getLoginUserInfo(String userCode);

    public List<LoginUser> queryUserList(LoginUserVo vo);

    public void addPeople(LoginUser vo);

    public void updatePeople(LoginUser vo);
}
