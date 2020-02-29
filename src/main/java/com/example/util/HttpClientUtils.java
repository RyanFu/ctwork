package com.example.util;

import com.alibaba.fastjson.JSONObject;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
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
     * get请求,不含请求头
     * @param url
     * @return
     */
    public static String doGet(String url){


        HttpGet get=new HttpGet(url);
        DefaultHttpClient client=new DefaultHttpClient();
        try {
            HttpResponse response=client.execute(get);
            String result=EntityUtils.toString(response.getEntity(),"utf-8");
            return result;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * get请求,携带请求头
     * @param   url
     * @return
     */
    public static String getMethod(String url,Map<String,String> headers){

        HttpGet get=new HttpGet(url);
        DefaultHttpClient client=new DefaultHttpClient();
        //封装请求头
        //Collection<Map.Entry<String,String>> entries=headers.entrySet();
        for (Map.Entry<String, String> header : headers.entrySet()){
            get.setHeader(header.getKey(),header.getValue());
        }


        try {
            HttpResponse response=client.execute(get);
            String result=EntityUtils.toString(response.getEntity(),"utf-8");
            return result;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 普通post请求,json请求参数
     * @param url
     * @param param
     * @return
     */
    public static String postMethod(String url, JSONObject param, Map<String,String> headers) {

        HttpPost post=new HttpPost(url);
        DefaultHttpClient client=new DefaultHttpClient();
        StringEntity entity=new StringEntity(param.toString(),"utf-8");
        //封装请求头，把map格式遍历出来
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
            return null;
        }

        /**
         * httpclient4.5.5写法
         * 可以关闭httpclient
         */

  /*      CloseableHttpClient httpClient= HttpClients.createDefault();
        HttpPost post=new HttpPost(url);
        StringEntity entity=new StringEntity(param.toString(),"utf-8");
        //封装请求头
        for (Map.Entry<String, String> header : headers.entrySet()){
            post.setHeader(header.getKey(),header.getValue());
        }
        post.setEntity(entity);
        try {
            CloseableHttpResponse response=httpClient.execute(post);
            String result=EntityUtils.toString(response.getEntity(),"utf-8");
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            return e.getMessage();
        } finally {
            try {
                httpClient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }*/

    }

    /**
     * 普通post请求,key-value
     * @param url
     * @param param
     * @return
     */
    public static String doPost(String url,Map<String,Object> param,Map<String,String> headers){

        HttpPost post=new HttpPost(url);
        DefaultHttpClient client=new DefaultHttpClient();
       try {
        //封装请求头
        for (Map.Entry<String, String> header : headers.entrySet()){
            post.setHeader(header.getKey(),header.getValue());
        }

        //装配post请求参数
        List<NameValuePair> list = new ArrayList<NameValuePair>();
        for (String key : param.keySet()) {
            list.add(new BasicNameValuePair(key, String.valueOf(param.get(key))));
        }

        //将参数进行编码为合适的格式,如将键值对编码为 param1=value1&param2=value2
        UrlEncodedFormEntity entity=new UrlEncodedFormEntity(list,"utf-8");
        post.setEntity(entity);

        HttpResponse response=client.execute(post);
        String result=EntityUtils.toString(response.getEntity(),"utf-8");

            return result;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


}
