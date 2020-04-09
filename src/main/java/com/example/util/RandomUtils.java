package com.example.util;

import java.util.Random;

/**
 * @Author: yicg
 * @Date: 2019/4/20 9:55
 * @Version 1.0
 */
public class RandomUtils {

    /**
     * 生成153和8位数随机数组成手机号
     * @return
     */
    public static String phoneUtil(){

        StringBuilder str=new StringBuilder();//定义变长字符串
        Random random=new Random();
        for(int i=0;i<8;i++){
            str.append(random.nextInt(10));
        }

        return "153"+str.toString();
    }

    /**
     * 随机一个数
     * @return
     */
    public static String randomBankUtil(){

        StringBuilder str=new StringBuilder();//定义变长字符串
        Random random=new Random();
        for(int i=0;i<1;i++){
            str.append(random.nextInt(5));
        }

        return str.toString();
    }

    /**
     * 随机n个数
     * @return
     */
    public static String randomUtil(int count){

        StringBuilder str=new StringBuilder();//定义变长字符串
        Random random=new Random();
        for(int i=0;i<count;i++){
            str.append(random.nextInt(5));
        }

        return str.toString();
    }
}