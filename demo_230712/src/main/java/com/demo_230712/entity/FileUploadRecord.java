package com.demo_230712.entity;

import lombok.Data;

import java.util.Date;

@Data
public class FileUploadRecord {

    private Integer id;
    private String fileName;
    private Double fileSize;
    private Date createTime;
    private String fileUrl;
}
