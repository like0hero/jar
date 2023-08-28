package com.demo_230712.util;

import com.demo_230712.bean.YmlConfigBean;
import com.demo_230712.controller.AliApi;
import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;

import java.util.HashMap;
import java.util.Map;
public class OCRUtil {

    //发票图片识别接口
    public static String invoiceOcr(String filePath){
        // 图片转二进制
        byte [] byte_data = AliApi.imgToByte(filePath);

        // 二进制转base64
        String imgBase64 =  AliApi.byteToBase64(byte_data);
        String method = "POST";
        Map<String, String> headers = new HashMap<String, String>();
        //最后在header中的格式(中间是英文空格)为Authorization:APPCODE 83359fd73fe94948385f570e3c139105
        headers.put("Authorization", "APPCODE " + YmlConfigBean.APPCODE);
        //根据API的要求，定义相对应的Content-Type
        headers.put("Content-Type", "application/json; charset=UTF-8");
        Map<String, String> querys = new HashMap<String, String>();
        String bodys = "{\"img\":\"" + imgBase64 + "\",\"url\":\"\"}";

        try {
            /**
             * 重要提示如下:
             * HttpUtils请从
             * https://github.com/aliyun/api-gateway-demo-sign-java/blob/master/src/main/java/com/aliyun/api/gateway/demo/util/HttpUtils.java
             * 下载
             *
             * 相应的依赖请参照
             * https://github.com/aliyun/api-gateway-demo-sign-java/blob/master/pom.xml
             */
            HttpResponse response = HttpUtils.doPost(YmlConfigBean.INVOICE_HOST, YmlConfigBean.INVOICE_PATH, method, headers, querys, bodys);
            System.out.println(response.toString());
            String str = EntityUtils.toString(response.getEntity());
            //获取response的body
            System.out.println(str);
            return str;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}