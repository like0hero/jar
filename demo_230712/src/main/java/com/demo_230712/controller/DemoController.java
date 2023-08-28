package com.demo_230712.controller;

import com.alibaba.fastjson.JSONObject;
import com.demo_230712.bean.YmlConfigBean;
import com.demo_230712.util.OCRUtil;
import com.demo_230712.util.UploadUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Random;

//@RestController
@Controller
public class DemoController {

    //通过controller返回html界面并传值到前端页面
    @RequestMapping("/index")
    public String indexJumpPage(HashMap<String, Object> map, Model model){
        model.addAttribute("say","欢迎欢迎,热烈欢迎");
        map.put("test", "111111");
        return "index";
    }

    @RequestMapping("/second")
    public String second(){
        return "second";
    }

    @RequestMapping("/third")
    public String third(){
        return "love";
    }

    @RequestMapping("/four")
    public String four(){
        return "yinghua";
    }

    @RequestMapping("/uploadPage")
    public String uploadPage(HashMap<String, Object> map, Model model){
        return "upload_show";
    }

    //发票上传接口
    @RequestMapping(value = "/upload",method = RequestMethod.POST)
    @ResponseBody
    public String upload(@RequestParam("file")MultipartFile file){
        if(file.isEmpty()){
            return "上传失败";
        }
        String endPath = UploadUtil.fileUpload(file, "invoic");
        String str = OCRUtil.invoiceOcr(endPath);
        JSONObject jsonObject = JSONObject.parseObject(str);
        return JSONObject.toJSONString(jsonObject.get("data"));
    }


    @RequestMapping("/tcpService")
    @ResponseBody
    public String tcpService(){
        try {
            ServerSocket serverSocket = new ServerSocket(9999);
            System.out.println("服务器已启动，等待客户端连接...");

            Socket socket = serverSocket.accept();
            System.out.println("客户端已连接，IP地址：" + socket.getInetAddress());

            // 处理客户端请求
            InputStream in = socket.getInputStream();
            byte[] bytes = new byte[1024];
            int i = in.read(bytes);
            String str = new String(bytes, 0, i);
            System.out.println("客户端消息：" + str);
            //4.返回数据给客户端。
            OutputStream out = socket.getOutputStream();
            out.write("我很好".getBytes());
            //5.关闭资源
            socket.close();
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "tcp成功";
    }

    @RequestMapping("/tcpCustom")
    @ResponseBody
    public String custom(){
        try {
            Socket socket = new Socket("127.0.0.1", 9999);
            System.out.println("已连接到服务器");

            OutputStream outputStream = socket.getOutputStream();
            outputStream.write("Hello, Server!".getBytes());

            InputStream inputStream = socket.getInputStream();
            byte[] buffer = new byte[1024];
            int length = inputStream.read(buffer);
            String response = new String(buffer, 0, length);
            System.out.println("服务器响应：" + response);

            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
            return "tcp失败";
        }
        return "tcp成功";
    }
}
