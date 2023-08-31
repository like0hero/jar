/*
package com.demo_230712.encry;

import cn.hutool.core.date.StopWatch;
import cn.hutool.core.util.RandomUtil;
import cn.hutool.crypto.SmUtil;
import cn.hutool.crypto.symmetric.SM4;

public class SM4Test {
    */
/**
     * sm4 对称加密 ,需要1个加密key
     *
     * @param args
     *//*

    public static void main(String[] args) {
        //SM4 requires a 128 bit key
        //需要一个长度为16的字符串 16*8=128 bit
        String key = RandomUtil.randomString(16);
        System.err.println("生成1个128bit的加密key:" + key);

        //原文
        String str = "hello";
        System.err.println("原文:" + str);

        StopWatch sw = StopWatch.create("q11");
        sw.start();

        SM4 sm41 = SmUtil.sm4(key.getBytes());
        //加密为Hex
        String hexPass = sm41.encryptHex(str);
        System.err.println("Hex形式的密文:" + hexPass);
        sw.stop();
        System.err.println(sw.getLastTaskInfo().getTimeSeconds());

        sw.start();
        //加密为base64
        String base64Pass = sm41.encryptBase64(str);
        System.err.println("base64形式的密文:" + base64Pass);
        sw.stop();
        System.err.println(sw.getLastTaskInfo().getTimeSeconds());

        System.err.println("--------------");
        //hex解密
        String s = sm41.decryptStr(hexPass);
        System.out.println(s);

        System.out.println("--------------");
        //base64解密
        String s2 = sm41.decryptStr(base64Pass);
        System.out.println(s2);
    }
}*/
