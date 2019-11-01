package com.example.util;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.CookieStore;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


/**
 * mmall工具类
 */
public class HttpUtils {

    public static CookieStore cookieStore;

    /**
     * 普通post请求,key-value,存储session
     * @param url
     * @param param
     * @return
     */
    public static String postForSession(String url, Map<String,Object> param, Map<String,Object> headers){

        HttpPost post=new HttpPost(url);
        DefaultHttpClient client=new DefaultHttpClient();

        try {

            //封装请求头
            for (Map.Entry<String, Object> header : headers.entrySet()){
                post.setHeader(header.getKey(),header.getValue().toString());
            }

            //装配post请求参数
            List<NameValuePair> list = new ArrayList<NameValuePair>();
            for (String key : param.keySet()) {
                list.add(new BasicNameValuePair(key, String.valueOf(param.get(key))));
            }

            //将参数进行编码为合适的格式,如将键值对编码为param1=value1&param2=value2
            UrlEncodedFormEntity entity=new UrlEncodedFormEntity(list,"utf-8");
            post.setEntity(entity);

            HttpResponse response=client.execute(post);
            String result=EntityUtils.toString(response.getEntity(),"utf-8");

            cookieStore=client.getCookieStore();
            return result;

        } catch (Exception e) {
            e.printStackTrace();
            return e.getMessage();
        }
    }

    /**
     * get请求,不含请求头,携带登录session请求
     * @param url
     * @return
     */
    public static String getWithSession(String url){

        HttpGet get=new HttpGet(url);
        DefaultHttpClient client=new DefaultHttpClient();
        try {
            client.setCookieStore(cookieStore);
            HttpResponse httpResponse=client.execute(get);
            String result=EntityUtils.toString(httpResponse.getEntity(),"utf-8");
            return result;
        } catch (IOException e) {
            e.printStackTrace();
            return e.getMessage();
        }
    }

}
