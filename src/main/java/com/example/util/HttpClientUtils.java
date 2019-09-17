package com.example.util;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

import java.io.IOException;
import java.util.Map;

/**
 * @Author: yicg
 * @Date: 2019/5/27 16:59
 * @Version 1.0
 *
 * httpclient工具类
 */
public class HttpClientUtils {


    /**
     * get请求
     * @param url
     * @return
     */
    public static String getMethod(String url,Map<String,String> headers){

        HttpGet get=new HttpGet(url);
        DefaultHttpClient client=new DefaultHttpClient();
        //封装请求头
        for (Map.Entry<String, String> header : headers.entrySet()){
            get.setHeader(header.getKey(),header.getValue());
        }

        try {
            HttpResponse response=client.execute(get);
            String result=EntityUtils.toString(response.getEntity(),"utf-8");
            return result;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 普通post请求
     * @param url
     * @param param
     * @return
     */
    public static String postMethod(String url,JSONObject param,Map<String,String> headers){

        HttpPost post=new HttpPost(url);
        DefaultHttpClient client=new DefaultHttpClient();
        StringEntity entity=new StringEntity(param.toString(),"utf-8");
        //封装请求头
        for (Map.Entry<String, String> header : headers.entrySet()){
            post.setHeader(header.getKey(),header.getValue());
        }

        post.setEntity(entity);

        try {
            HttpResponse response=client.execute(post);
            String result=EntityUtils.toString(response.getEntity(),"utf-8");

            return result;

        } catch (Exception e) {
            e.printStackTrace();
        }
       return null;
    }
}
