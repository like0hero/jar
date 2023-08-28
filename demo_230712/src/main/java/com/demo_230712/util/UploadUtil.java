package com.demo_230712.util;

import com.demo_230712.bean.Result;
import com.demo_230712.bean.YmlConfigBean;
import com.demo_230712.entity.FileUploadRecord;
import com.demo_230712.service.ILoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class UploadUtil {

    public static String fileUpload(MultipartFile file, String folder){
        String fileName = file.getOriginalFilename();
        String suffixName = fileName.substring(fileName.lastIndexOf("."));
        //生成新文件名
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd_HHmmss");
        Random r = new Random();
        StringBuilder tempName = new StringBuilder();
        tempName.append(sdf.format(new Date())).append(r.nextInt(100)).append(suffixName);
        String newFileName = tempName.toString();
        String filePath = YmlConfigBean.FILE_UPLOAD_PATH + folder; //上传发票文件存储目录
        String endPath = folderSplit(filePath) + newFileName;
        try {
            byte[] bytes=file.getBytes();
            Path path = Paths.get(endPath);
            Files.write(path,bytes);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return endPath;
    }

    public static String folderSplit(String basePath){
        String dayStr = DateUtil.getDate();
        String[] dayArr = dayStr.split("-");

        String year = dayArr[0];
        String month = dayArr[1];
        String day = dayArr[2];

        String yearDir = basePath + File.separator + year;
        File yearFile = new File(yearDir);
        if (!yearFile.exists()) {
            yearFile.mkdirs();
        }

        String monthDir = yearDir + File.separator + month;
        File monthFile = new File(monthDir);
        if (!monthFile.exists()) {
            monthFile.mkdirs();
        }

        String dayDir = monthDir + File.separator + day + File.separator;
        dayDir = dayDir.replace("\\", "/");
        File dayFile = new File(dayDir);
        if (!dayFile.exists()) {
            dayFile.mkdirs();
        }
        return dayDir;
    }
}
