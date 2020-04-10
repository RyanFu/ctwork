package com.example.util;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.*;
import org.apache.http.client.CookieStore;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.CoreConnectionPNames;
import org.apache.http.util.EntityUtils;
import org.springframework.web.util.UriBuilder;
import org.testng.collections.Lists;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Author: yicg
 * @Date: 2019/5/27 16:59
 * @Version 1.0
 *
 *
 * httpclient工具类   httpclient版本4.1.2
 */
@Slf4j
public class HttpClientUtils {

    public static CookieStore cookieStore;
    public static int resultCode;

    /**
     * get请求,不含请求头,不含参数,只依赖登录生成的cookie
     * @param url
     * @return
     */
    public static String doGetOnlyUrl(String url){


        HttpGet get=new HttpGet(url);
        DefaultHttpClient client=new DefaultHttpClient();
        try {
            HttpResponse response=client.execute(get);
            resultCode=response.getStatusLine().getStatusCode();
            String result=EntityUtils.toString(response.getEntity(),"utf-8");
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * get请求,需要请求头，无参数
     * @param   url
     * @return
     */
    public static String doGetWithHeads(String url,Map<String,String> headers){

        HttpGet get=new HttpGet(url);
        DefaultHttpClient client=new DefaultHttpClient();
        //httpclient设置超时时间
        client.getParams().setParameter(CoreConnectionPNames.CONNECTION_TIMEOUT,10000);
        client.getParams().setParameter(CoreConnectionPNames.SO_TIMEOUT,10000);

        //封装请求头
        //Collection<Map.Entry<String,String>> entries=headers.entrySet();
        for (Map.Entry<String, String> header : headers.entrySet()){
            get.setHeader(header.getKey(),header.getValue());
        }

        try {
            HttpResponse response=client.execute(get);
            resultCode=response.getStatusLine().getStatusCode();
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
    public static String doPostWithJson(String url, JSONObject param, Map<String,String> headers) {

        HttpPost post=new HttpPost(url);
        DefaultHttpClient client=new DefaultHttpClient();
        //httpclient4.3设置超时时间
        client.getParams().setParameter(CoreConnectionPNames.CONNECTION_TIMEOUT,10000);
        client.getParams().setParameter(CoreConnectionPNames.SO_TIMEOUT,10000);

        StringEntity entity=new StringEntity(param.toString(),"utf-8");
        //封装请求头，把map格式遍历出来
        for (Map.Entry<String, String> header : headers.entrySet()){
            post.setHeader(header.getKey(),header.getValue());
        }
        post.setEntity(entity);
        try {
            HttpResponse response=client.execute(post);
            resultCode=response.getStatusLine().getStatusCode();
            String result=EntityUtils.toString(response.getEntity(),"utf-8");
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    /**
     * 普通post请求,key-value
     * @param url
     * @param param
     * @return
     */
    public static String doPostWithKeyValue(String url,Map<String,Object> param,Map<String,String> headers){

        HttpPost post=new HttpPost(url);
        DefaultHttpClient client=new DefaultHttpClient();
        //httpclient4.3设置超时时间
        client.getParams().setParameter(CoreConnectionPNames.CONNECTION_TIMEOUT,10000);
        client.getParams().setParameter(CoreConnectionPNames.SO_TIMEOUT,10000);

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
        resultCode=response.getStatusLine().getStatusCode();
        String result=EntityUtils.toString(response.getEntity(),"utf-8");

            return result;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }





    /**
     * 普通post请求,key-value,生成session
     * @param url
     * @param param  com.alibaba.fastjson.JSONObject实现了Map，可以使用map下的方法
     * @return
     */
    public static String doPostWithKeyValueGetSession(String url, JSONObject param, Map<String,String> headers){

        HttpPost post=new HttpPost(url);
        DefaultHttpClient client=new DefaultHttpClient();
        //httpclient4.3设置超时时间
        client.getParams().setParameter(CoreConnectionPNames.CONNECTION_TIMEOUT,10000);
        client.getParams().setParameter(CoreConnectionPNames.SO_TIMEOUT,10000);

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

            //将参数进行编码为合适的格式,如将键值对编码为param1=value1&param2=value2
            UrlEncodedFormEntity entity=new UrlEncodedFormEntity(list,"utf-8");
            post.setEntity(entity);

            HttpResponse response=client.execute(post);
            String result=EntityUtils.toString(response.getEntity(),"utf-8");
            resultCode=response.getStatusLine().getStatusCode();
            cookieStore=client.getCookieStore();
            log.info("登录生成的COOKIES:{}",cookieStore);
            return result;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


    /**
     * get请求,不含请求头,不含参数，携带登录session请求
     * @param url
     * @return
     */
    public static String doGetOnlyUrlWithSession(String url){

        HttpGet get=new HttpGet(url);
        DefaultHttpClient client=new DefaultHttpClient();
        //httpclient4.3设置超时时间
        client.getParams().setParameter(CoreConnectionPNames.CONNECTION_TIMEOUT,10000);
        client.getParams().setParameter(CoreConnectionPNames.SO_TIMEOUT,10000);

        try {
            client.setCookieStore(cookieStore);
            log.info("接口发送COOKIES:{}",cookieStore);
            HttpResponse httpResponse=client.execute(get);
            String result=EntityUtils.toString(httpResponse.getEntity(),"utf-8");
            resultCode=httpResponse.getStatusLine().getStatusCode();
            return result;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 普通get请求，需要参数?key=value ，依赖登录生成的cookies
     * @param url
     * @param param
     * @return
     */
    public static String doGetWithParamsWithSession(String url,JSONObject param) {
        DefaultHttpClient client=new DefaultHttpClient();
        client.setCookieStore(cookieStore);
        //封装请求参数
        List<NameValuePair> list = new ArrayList<NameValuePair>();
        for (String key : param.keySet()) {
            list.add(new BasicNameValuePair(key, String.valueOf(param.get(key))));
        }
        try {
            String requestParams=EntityUtils.toString(new UrlEncodedFormEntity(list, Consts.UTF_8));
            HttpGet get=new HttpGet(url+"?"+requestParams);
            log.info("get请求数据:{}",url+"?"+requestParams);
            HttpResponse httpResponse=client.execute(get);
            String result=EntityUtils.toString(httpResponse.getEntity(),"utf-8");
            resultCode=httpResponse.getStatusLine().getStatusCode();
            return result;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
   }

















    /**
     * 替换模版参数
     *
     * @param bodyPattern
     * @param param
     * @return
     */
    public static String makeParamter(String bodyPattern, Map<String, String> param, HashMap<String, String> converMap) {

        List<String> ls = new ArrayList<String>();
        Pattern pattern = Pattern.compile("(\\$\\{[^\\}]+})");
        Matcher matcher = pattern.matcher(bodyPattern);
        while (matcher.find()) {
            String key = matcher.group();
            String convertKey = converMap.get(formatParamCode(key));
            log.info(" body pattern key = " + key + " convert to  " + convertKey);
            convertKey = (convertKey == null ? key : convertKey);
            String value = param.get(convertKey);
            bodyPattern = bodyPattern.replace(key, value == null ? "" : value);
        }
        return bodyPattern;
    }
    private static String formatParamCode(String paramCode) {
        return paramCode.replaceAll("\\$", "").replaceAll("\\{", "").replaceAll("\\}", "");
    }
}
