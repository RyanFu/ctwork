package com.example.util;

import org.testng.annotations.Test;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author: yicg
 * @Date: 2019/4/4 17:31
 * @Version 1.0
 */
public class MD5Utils {
    /**
     * 使用md5的算法进行加密
     */
    public static String md5(String plainText) {

        byte[] secretBytes = null;
        try {
            secretBytes = MessageDigest.getInstance("md5").digest(
                    plainText.getBytes());
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("没有md5这个算法！");
        }
        String md5code = new BigInteger(1, secretBytes).toString(16);// // 16进制数字
        // 如果生成数字未满32位，需要前面补0
        for (int i = 0; i < 32 - md5code.length(); i++) {
            md5code = "0" + md5code;
        }
        return md5code;
    }


    public static void main(String[] args) {
        String date=DateTimeUtils.formatDateTime(new Date(),"yyyyMMddHHmmssSSS");
        String phoneMD5=md5("1811435305");
        String reqId=date+phoneMD5;

        String s="P7N8Tbh4E2oncpfXf89Lt8DG7Legw1z0"+"&"+reqId+"&"+date;
        String sign=md5(s);
        System.out.println("phoneMD5="+phoneMD5);
        System.out.println("time="+date);
        System.out.println("reqId="+reqId);
        System.out.println("sign="+sign);
    }

    @Test
    public void test(){

    }

}