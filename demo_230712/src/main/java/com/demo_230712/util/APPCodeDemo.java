package com.demo_230712.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.apache.commons.codec.binary.Base64.encodeBase64;



/**
 * 使用APPCODE进行云市场ocr服务接口调用
 */

public class APPCodeDemo {

    /*
     * 获取参数的json对象
     */
    public static JSONObject getParam(int type, String dataValue) {
        JSONObject obj = new JSONObject();
        try {
            obj.put("dataType", type);
            obj.put("dataValue", dataValue);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return obj;
    }

    public static void main(String[] args){

        String host = "https://form.market.alicloudapi.com";
        String path = "/api/predict/ocr_table_parse";
        String appcode = "b4f4f08c14234b158ed822de51f9147d";
        String imgFile = "D:\\1.jpg";
        Boolean is_old_format = false;//如果文档的输入中含有inputs字段，设置为True， 否则设置为False
        //请根据线上文档修改configure字段
        JSONObject configObj = new JSONObject();
        configObj.put("format", "json");    //输出格式：html/json/xlsx;
        configObj.put("finance", false);
        configObj.put("dir_assure", true); //图片方向是否确定是正向的: true(确定)/false(不确定)
        configObj.put("line_less", true);   //是否无线条: true(无线条,或者只有横线没有竖线)/false(有线条)
        String config_str = configObj.toString();
        //configObj.put("min_size", 5);
        //String config_str = "";

        String method = "POST";
        Map<String, String> headers = new HashMap<String, String>();
        //最后在header中的格式(中间是英文空格)为Authorization:APPCODE 83359fd73fe94948385f570e3c139105
        headers.put("Authorization", "APPCODE " + appcode);

        Map<String, String> querys = new HashMap<String, String>();

        // 对图像进行base64编码
        String imgBase64 = "";
        try {
            File file = new File(imgFile);
            byte[] content = new byte[(int) file.length()];
            FileInputStream finputstream = new FileInputStream(file);
            finputstream.read(content);
            finputstream.close();
            imgBase64 = new String(encodeBase64(content));
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }
        // 拼装请求body的json字符串
        JSONObject requestObj = new JSONObject();
        try {
            if(is_old_format) {
                JSONObject obj = new JSONObject();
                obj.put("image", getParam(50, imgBase64));
                if(config_str.length() > 0) {
                    obj.put("configure", getParam(50, config_str));
                }
                JSONArray inputArray = new JSONArray();
                inputArray.add(obj);
                requestObj.put("inputs", inputArray);
            }else{
                requestObj.put("image", imgBase64);
                if(config_str.length() > 0) {
                    requestObj.put("configure", config_str);
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        String bodys = requestObj.toString();

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
            int stat = response.getStatusLine().getStatusCode();
            if(stat != 200){
                System.out.println("Http code: " + stat);
                System.out.println("http header error msg: "+ response.getFirstHeader("X-Ca-Error-Message"));
                System.out.println("Http body error msg:" + EntityUtils.toString(response.getEntity()));
                return;
            }

            String res = EntityUtils.toString(response.getEntity());
            JSONObject res_obj = JSON.parseObject(res);
            List<Map<String, Object>> list = new ArrayList<>();
            Map<String, Object> map = null;
            if(is_old_format) {
                JSONArray outputArray = res_obj.getJSONArray("outputs");
                String output = outputArray.getJSONObject(0).getJSONObject("outputValue").getString("dataValue");
                JSONObject out = JSON.parseObject(output);
                //System.out.println(out.toJSONString());
            }else{
                //System.out.println(res_obj.toJSONString());
                JSONArray tables = res_obj.getJSONArray("tables");
                JSONArray second = (JSONArray) tables.get(0);
                for (int i = 4; i < second.size() - 1; i++) {
                    JSONArray jsonArray = (JSONArray) second.get(i);
                    List<String> strList = new ArrayList<>();
                    map = new HashMap<>();
                    for (int i1 = 0; i1 < jsonArray.size(); i1++) {
                        JSONObject trhired = (JSONObject) jsonArray.get(i1);
                        Integer sx = Integer.valueOf(trhired.getString("sx"));
                        strList.add(sx.toString());
                        switch (sx){
                            case 0:
                                map.put("no", trhired.getString("text").replace("[", "").replace("]", "").replace("\"", ""));
                                break;
                            case 1:
                                map.put("date",trhired.getString("text").replace("[", "").replace("]", "").replace("\"", ""));
                                break;
                            case 2:
                                map.put("dealer",trhired.getString("text").replace("[", "").replace("]", "").replace("\"", ""));
                                break;
                            case 3:
                                map.put("orderNo",trhired.getString("text").replace("[", "").replace("]", "").replace("\"", ""));
                                break;
                            case 4:
                                map.put("mileage",trhired.getString("text").replace("[", "").replace("]", "").replace("\"", ""));
                                break;
                            case 5:
                                map.put("serviceType",trhired.getString("text").replace("[", "").replace("]", "").replace("\"", ""));
                                break;
                            case 7:
                                map.put("paymentType",trhired.getString("text").replace("[", "").replace("]", "").replace("\"", ""));
                                break;
                            default:
                                break;
                        }
                    }
                    if(jsonArray.size() < 7){
                        String[] allSx = {"0", "1", "2", "3", "4", "5", "7"};
                        List<String> diffrent = getDiffrent(Arrays.asList(allSx), strList);
                        for (String s : diffrent) {
                            switch (Integer.valueOf(s)){
                                case 0:
                                    map.put("no", "无");
                                    break;
                                case 1:
                                    map.put("date", "无");
                                    break;
                                case 2:
                                    map.put("dealer", "无");
                                    break;
                                case 3:
                                    map.put("orderNo", "无");
                                    break;
                                case 4:
                                    map.put("mileage", "无");
                                    break;
                                case 5:
                                    map.put("serviceType", "无");
                                    break;
                                case 7:
                                    map.put("paymentType", "无");
                                    break;
                                default:
                                    break;
                            }
                        }
                    }
                    list.add(map);
                }
            }
            for (Map<String, Object> mapNew : list) {
                System.out.println(mapNew.get("no") + "--" + mapNew.get("date") + "--" + mapNew.get("dealer") + "--" + mapNew.get("orderNo") + "--" + mapNew.get("mileage") + "--" + mapNew.get("serviceType") + "--" + mapNew.get("paymentType"));
            }
            long end = System.currentTimeMillis();
            System.out.println(end - start);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //判断两个集合中不同的值
    public static List<String> getDiffrent(List<String> list1, List<String> list2){
        Map<String,Integer> map = new HashMap<String,Integer>(list1.size()+list2.size());
        List<String> diff = new ArrayList<String>();
        List<String> maxList = list1;
        List<String> minList = list2;
        if(list2.size()>list1.size()){
            maxList = list2;
            minList = list1;
        }

        for (String string : maxList){
            map.put(string, 1);
        }

        for (String string : minList){
            Integer cc = map.get(string);
            if(cc!=null){
                map.put(string, ++cc);
                continue;
            }
            map.put(string, 1);
        }

        for(Map.Entry<String, Integer> entry:map.entrySet()){
            if(entry.getValue()==1)
            {
                diff.add(entry.getKey());
            }
        }
        return diff;
    }
}