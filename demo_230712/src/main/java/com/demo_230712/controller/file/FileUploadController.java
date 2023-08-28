package com.demo_230712.controller.file;

import com.demo_230712.bean.Result;
import com.demo_230712.entity.FileUploadRecord;
import com.demo_230712.service.IFileUploadService;
import com.demo_230712.util.UploadUtil;
import com.demo_230712.vo.FileUploadVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.util.Date;

@Controller
@RequestMapping("/fileUpload")
public class FileUploadController {

    @Autowired
    private IFileUploadService fileUploadService;


    //上传文件
    @RequestMapping("/uploadFileToLocal")
    @ResponseBody
    public Result uploadFileToLocal(@RequestParam("multipartFile") MultipartFile multipartFile){
        if(multipartFile.isEmpty()){
            return Result.error("上传失败");
        }
        FileUploadRecord fileUploadRecord = new FileUploadRecord();
        String fileName = multipartFile.getOriginalFilename();
        String endPath = UploadUtil.fileUpload(multipartFile, fileName.substring(fileName.lastIndexOf(".")).replace(".", ""));
        fileUploadRecord.setFileName(fileName);
        fileUploadRecord.setFileSize(Double.valueOf(multipartFile.getSize()));
        fileUploadRecord.setFileUrl(endPath.substring(10));
        fileUploadRecord.setCreateTime(new Date());
        fileUploadService.addFileUploadRecord(fileUploadRecord);
        return Result.ok();
    }

    //获取文件列表
    @RequestMapping("/queryFilesList")
    @ResponseBody
    public Result queryFilesList(@RequestBody FileUploadVo vo){
        Result result = fileUploadService.queryFileList(vo);
        return result;
    }

    @RequestMapping("/onlinePreview")
    @ResponseBody
    public Result onlinePreview(@RequestParam(value = "fileUrl") String fileUrl, HttpServletResponse response) throws Exception {
        return fileUploadService.onlinePreview(fileUrl, response);
    }

    /*private String writeImgToUpload(MultipartFile multipartFile, String userName) {
        // Tomcat 放在C盘中，可能无读写权限而写入失败
        // 写入目录文件
        // 获取文件格式
        String suffix = multipartFile.getOriginalFilename().substring(multipartFile.getOriginalFilename().lastIndexOf("."));
        // 目标文件路径+文件名
        String imgFile = YmlConfigBean.FILE_UPLOAD_PATH + userName + suffix;
        File toFile = new File(imgFile);
        if (!toFile.getParentFile().exists()) {
            // when file is not existed, will create.
            toFile.mkdirs();
        }
        // write to target file.
        try {
            multipartFile.transferTo(toFile);
            return imgFile;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }*/
}
