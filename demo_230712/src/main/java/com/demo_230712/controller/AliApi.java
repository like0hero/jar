package com.demo_230712.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.demo_230712.util.HttpUtils;
import org.apache.commons.codec.binary.Base64;
import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

public class AliApi {

    //阿里云发票识别
    /*public static void main(String[] args) {
        String host = "https://dgfp.market.alicloudapi.com";
        String path = "/ocrservice/invoice";
        String method = "POST";
        String appcode = "b4f4f08c14234b158ed822de51f9147d";
        Map<String, String> headers = new HashMap<String, String>();
        //最后在header中的格式(中间是英文空格)为Authorization:APPCODE 83359fd73fe94948385f570e3c139105
        headers.put("Authorization", "APPCODE " + appcode);
        //根据API的要求，定义相对应的Content-Type
        headers.put("Content-Type", "application/json; charset=UTF-8");
        Map<String, String> querys = new HashMap<String, String>();
        String bodys = "{\"img\":\"\",\"url\":\"https://shch.dbguisheng.com//agora/recording-file/20230404/penghp_064648_184149348/1.jpg\"}";


        try {
            *//**
             * 重要提示如下:
             * HttpUtils请从
             * https://github.com/aliyun/api-gateway-demo-sign-java/blob/master/src/main/java/com/aliyun/api/gateway/demo/util/HttpUtils.java
             * 下载
             *
             * 相应的依赖请参照
             * https://github.com/aliyun/api-gateway-demo-sign-java/blob/master/pom.xml
             *//*
            HttpResponse response = HttpUtils.doPost(host, path, method, headers, querys, bodys);
            System.out.println(response.toString());
            //获取response的body
            System.out.println(EntityUtils.toString(response.getEntity()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }*/

    //通用高精版识别
    public static void main(String[] args) {


        String host = "https://gjbsb.market.alicloudapi.com";
        String path = "/ocrservice/advanced";
        String method = "POST";
        String appcode = "b4f4f08c14234b158ed822de51f9147d";
        Map<String, String> headers = new HashMap<String, String>();
        //最后在header中的格式(中间是英文空格)为Authorization:APPCODE 83359fd73fe94948385f570e3c139105
        headers.put("Authorization", "APPCODE " + appcode);
        //根据API的要求，定义相对应的Content-Type
        headers.put("Content-Type", "application/json; charset=UTF-8");
        Map<String, String> querys = new HashMap<String, String>();
        String bodys = "{\n" +
                "  \"img\": \"\",\n" +
                "  \"url\": \"https://shch.dbguisheng.com//agora/recording-file/20230404/penghp_064648_184149348/2.jpg\",\n" +
                "  \"prob\": false,\n" +
                "  \"charInfo\": true,\n" +
                "  \"rotate\": false,\n" +
                "  \"table\": true,\n" +
                "  \"sortPage\": false,\n" +
                "  \"noStamp\": false,\n" +
                "  \"figure\": false,\n" +
                "  \"row\": true,\n" +
                "  \"paragraph\": false,\n" +
                "  \"oricoord\": true\n" +
                "}";
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
            // 开始时间
            long start = System.currentTimeMillis();
            HttpResponse response = HttpUtils.doPost(host, path, method, headers, querys, bodys);
            long end = System.currentTimeMillis();
            System.out.println(end - start);
            //System.out.println(response.toString());
            String str = EntityUtils.toString(response.getEntity());
            //获取response的body
            //System.out.println(str);
            JSONObject obj = JSON.parseObject(str);
            //System.out.println(obj.getString("content"));
            JSONArray jsonArray = obj.getJSONArray("prism_rowsInfo");
            Map<String, Object> map = new HashMap<>();
            for (int i = 0; i < jsonArray.size(); i++) {
                JSONObject jsonObject = (JSONObject) jsonArray.get(i);
                Integer rowId = jsonObject.getInteger("rowId");
                switch (rowId){
                    case 4:
                        map.put("carId", jsonObject.getString("word"));
                        break;
                    case 5:
                        map.put("carId", map.get("carId") + jsonObject.getString("word"));
                        break;
                    case 6:
                        map.put("fin", jsonObject.getString("word"));
                        break;
                    case 11:
                        map.put("engineNo", jsonObject.getString("word"));
                        break;
                    case 13:
                        map.put("carColor", jsonObject.getString("word"));
                        break;
                    case 18:
                        map.put("vin", jsonObject.getString("word"));
                        break;
                    case 20:
                        map.put("firstDate", jsonObject.getString("word"));
                        break;
                    case 26:
                        map.put("finishDate", jsonObject.getString("word"));
                        break;
                    case 28:
                        map.put("color", jsonObject.getString("word"));
                        break;
                }
            }
            map.forEach((key, value) -> {
                System.out.println(key + ":" + value);
            });

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //自定义模板
    /*public static void main(String[] args) {
        // 图片路径
        String file_path = "D:\\2.jpg";

        // 图片转二进制
        byte [] byte_data = imgToByte(file_path);

        // 二进制转base64
        String imgBase64 =  byteToBase64(byte_data);

        String host = "https://ocrdiy.market.alicloudapi.com";
        String path = "/api/predict/ocr_sdt";
        String method = "POST";
        String appcode = "b4f4f08c14234b158ed822de51f9147d";
        Map<String, String> headers = new HashMap<String, String>();
        //最后在header中的格式(中间是英文空格)为Authorization:APPCODE 83359fd73fe94948385f570e3c139105
        headers.put("Authorization", "APPCODE " + appcode);
        //根据API的要求，定义相对应的Content-Type
        headers.put("Content-Type", "application/json; charset=UTF-8");
        Map<String, String> querys = new HashMap<String, String>();
        String bodys = "{\n" +
                "   \"image\": \"https://shch.dbguisheng.com//agora/recording-file/20230404/penghp_064648_184149348/1.jpg\",\n" +
                "   \"configure\":{\"template_list\": [\n" +
                "                {\"template_id\": \"7bc26bd7-41ad-4145-9f5a-4af21b26de9a\", #costa的模板id\n" +
                "                 \"cond\": {\"include\":\"序号\"}\n" +
                "                },\n" +
                "                {\"template_id\": \"7bc26bd7-41ad-4145-9f5a-4af26de9a\", #costa的模板id\n" +
                "                 \"cond\": {\"include\":\"维修日期\"}\n" +
                "                },\n" +
                "                {\"template_id\": \"7bc26bd7-41ad-4145-9f5a-4af26de1a\", #costa的模板id\n" +
                "                 \"cond\": {\"include\":\"经销商\"}\n" +
                "                },\n" +
                "                {\"template_id\": \"7bc26bd7-41ad-4145-9f5a-4af26de2a\", #costa的模板id\n" +
                "                 \"cond\": {\"include\":\"订单号\"}\n" +
                "                },\n" +
                "                {\"template_id\": \"7bc26bd7-41ad-4145-9f5a-4af26de3a\", #costa的模板id\n" +
                "                 \"cond\": {\"include\":\"里程\"}\n" +
                "                },\n" +
                "                {\"template_id\": \"7bc26bd7-41ad-4145-9f5a-4af26de4a\", #costa的模板id\n" +
                "                 \"cond\": {\"include\":\"服务类型\"}\n" +
                "                },\n" +
                "                {\"template_id\": \"7bc26bd7-41ad-4145-9f5a-4af26de5a\", #costa的模板id\n" +
                "                 \"cond\": {\"include\":\"付款类型\"}\n" +
                "                }\n" +
                "]\n" +
                "               }  \n" +
                "}";


        try {
            *//**
             * 重要提示如下:
             * HttpUtils请从
             * https://github.com/aliyun/api-gateway-demo-sign-java/blob/master/src/main/java/com/aliyun/api/gateway/demo/util/HttpUtils.java
             * 下载
             *
             * 相应的依赖请参照
             * https://github.com/aliyun/api-gateway-demo-sign-java/blob/master/pom.xml
             *//*
            HttpResponse response = HttpUtils.doPost(host, path, method, headers, querys, bodys);
            System.out.println(response.toString());
            //获取response的body
            //System.out.println(EntityUtils.toString(response.getEntity()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }*/

    /**
     * 传入图片路径,将图片转为二进制数据传出为byte[]
     */
    public static byte [] imgToByte(String file){
        File img1 = new File(file);
        if (!img1.exists())return new byte[0];
        try {
            InputStream in = new FileInputStream(img1);
            BufferedInputStream bufferedInputStream = new BufferedInputStream(in);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

            byte [] buf = new byte[(int) img1.length()];
            int len;
            if ((len=bufferedInputStream.read(buf))>=0){
                byteArrayOutputStream.write(buf, 0 , len);
            }
            System.out.println("Successfully converted to byte data ! ! !");
            return byteArrayOutputStream.toByteArray();

        }  catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    /**
     * 二进制转base64数据
     */
    public static String byteToBase64(byte [] by) {
        byte[] base64_data = Base64.encodeBase64(by);
        String S_B64 = new String(base64_data);
        System.out.println("Successfully converted to base64 data ! ! !");
        return S_B64;
    }


}

