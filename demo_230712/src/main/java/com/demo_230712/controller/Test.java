package com.demo_230712.controller;

import com.demo_230712.util.DateUtil;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test {
    /**
     * 服务器
     */
    static class Myserve{
        static void test() throws IOException {
            //1.创建服务器端口
            ServerSocket serverSocket = new ServerSocket(7777);
            //2.阻塞式等待客户连接，接受套接字对象
            Socket client = serverSocket.accept();
            //3.进行操作，例如获取流
            BufferedReader brd = new BufferedReader(new InputStreamReader(client.getInputStream()));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(serverSocket.accept().getOutputStream()));
            bw.write("你谁啊?");
            //4.关闭资源
            brd.close();
            serverSocket.close();
        }
    }

    /**
     * 客户端
     */
    static class Myclient{
        static void test() throws IOException {
            //1.创建套接字对象,指定目的地址和端口
            Socket client = new Socket("localhost",7777);//2.操作
            BufferedReader brd = new BufferedReader(new InputStreamReader(System.in));
            String datas = brd.readLine();

            //把datas写入传输流
            BufferedOutputStream bos = new BufferedOutputStream(client.getOutputStream());
            bos.write(datas.getBytes());
            OutputStream os = client.getOutputStream();
            os.write("hello".getBytes());

            //3.关闭资源
            bos.close();
            client.close();
        }
    }

    public static void main(String[] args) throws IOException {
        Myserve.test();
        Myclient.test();
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
