package com.demo_230712.service;

import com.demo_230712.bean.Result;
import com.demo_230712.entity.FileUploadRecord;
import com.demo_230712.vo.FileUploadVo;

import javax.servlet.http.HttpServletResponse;

public interface IFileUploadService {
    //获取数据列表
    public Result queryFileList(FileUploadVo vo);

    //上传文件
    Result addFileUploadRecord(FileUploadRecord vo);

    public Result onlinePreview(String url, HttpServletResponse response) throws Exception;
}
