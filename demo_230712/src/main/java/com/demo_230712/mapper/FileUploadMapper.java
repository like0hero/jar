package com.demo_230712.mapper;

import com.demo_230712.entity.FileUploadRecord;
import com.demo_230712.vo.FileUploadVo;

import java.util.List;

public interface FileUploadMapper {

    public void addFileUploadRecord(FileUploadRecord fileUploadRecord);

    public List<FileUploadRecord> queryFileList(FileUploadVo vo);
}
