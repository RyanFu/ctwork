package com.example.mbg;

import com.google.common.collect.Maps;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.message.BasicNameValuePair;

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author yicg
 * @createTime 2020年03月23日 17:10:00
 * @Description
 */
public class Test {


    public static void main(String[] args) {

        Map<String,Object> map=Maps.newHashMap();
        map.put("name","zhangsan");
        map.put("head","application/json");
        map.put("password","1234567");


        Set<Map.Entry<String,Object>> set=map.entrySet();

        for(Map.Entry<String,Object> maps:set){
            System.out.println(maps.getKey()+" "+maps.getValue());
        }



        //装配post请求参数
        List<NameValuePair> list = new ArrayList<NameValuePair>();
        for (String key : map.keySet()) {
            list.add(new BasicNameValuePair(key, String.valueOf(map.get(key))));
        }

        try {
            UrlEncodedFormEntity entity=new UrlEncodedFormEntity(list,"utf-8");
            System.out.println(entity);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        System.out.println(list);

        myThrows(3);

        dateSampleFormat();

    }




    public static void myThrows(int a){


        float x=100/a  ;
        if(a==0){
            throw new RuntimeException("除数不能为0");
        }
        System.out.println(x);
    }



        public static void dateSampleFormat() {
            SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date date=new Date();
            String time=format.format(date);
            System.out.println(time);

            System.out.println(format.format(System.currentTimeMillis()));
        }


}
