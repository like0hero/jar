package com.demo_230712.service.impl;

import com.demo_230712.bean.Result;
import com.demo_230712.entity.FileUploadRecord;
import com.demo_230712.mapper.FileUploadMapper;
import com.demo_230712.service.IFileUploadService;
import com.demo_230712.util.FileConvertUtil;
import com.demo_230712.vo.FileUploadVo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.InputStream;
import java.io.OutputStream;

@Service
public class IFileUploadServiceImpl implements IFileUploadService {
    @Resource
    private FileUploadMapper fileUploadMapper;

    @Override
    public Result queryFileList(FileUploadVo vo) {
        return Result.success(fileUploadMapper.queryFileList(vo));
    }

    @Override
    public Result addFileUploadRecord(FileUploadRecord vo) {
        fileUploadMapper.addFileUploadRecord(vo);
        return Result.success(0);
    }

    /**
     * @Description:系统文件在线预览接口
     */
    public Result onlinePreview(String url, HttpServletResponse response) throws Exception {
        //获取文件类型
        String[] str = url.split("\\.");

        if (str.length == 0) {
            return Result.error("文件格式不正确");
        }
        String suffix = str[str.length - 1];
        //将文件名后缀统一转化 这是因为转换07版本及高版本（.docx/.xlsx/.pptx）时，这三种格式不在所支持的文件格式中。所以需要转化
        if (suffix.indexOf("doc") >= 0) {
            suffix = "doc";
        }
        if (suffix.indexOf("ppt") >= 0) {
            suffix = "ppt";
        }
        if (suffix.indexOf("xls") >= 0) {
            suffix = "xls";
        }
        if (!suffix.equals("txt") && !suffix.equals("doc") && !suffix.equals("docx") && !suffix.equals("xls")
                && !suffix.equals("xlsx") && !suffix.equals("ppt") && !suffix.equals("pptx")) {
            return Result.error("文件格式不支持预览");
        }
        InputStream in = FileConvertUtil.convertNetFile(url, suffix);
        OutputStream outputStream = response.getOutputStream();
        //创建存放文件内容的数组
        byte[] buff = new byte[1024];
        //所读取的内容使用n来接收
        int n;
        //当没有读取完时,继续读取,循环
        while ((n = in.read(buff)) != -1) {
            //将字节数组的数据全部写入到输出流中
            outputStream.write(buff, 0, n);
        }
        //强制将缓存区的数据进行输出
        outputStream.flush();
        //关流
        outputStream.close();
        in.close();
        return Result.ok();
    }
}
