package com.example.util;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.*;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.springframework.util.StringUtils;

import java.io.IOException;
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

    public static int resultCode;

    //连接超时时间
    private static final int CONNECTION_TIMEOUT=10000;
    //从连接池中取的连接的最长时间
    private static final int REQUEST_TIMEOUT=10000;
    //数据传输的超时时间
    private static final int SOCKET_TIMEOUT=10000;




    /**
     * 普通post请求,json请求参数
     * @param url
     * @param param
     * @return
     */
    public static String doPostWithJson(String url, JSONObject param, Map<String,String> headers) {

        HttpPost post=new HttpPost(url);
        CloseableHttpClient client=HttpClients.createDefault();
        RequestConfig config = RequestConfig.custom()
                .setConnectTimeout(CONNECTION_TIMEOUT)
                .setConnectionRequestTimeout(REQUEST_TIMEOUT)
                .setSocketTimeout(SOCKET_TIMEOUT)
                .build();
        post.setConfig(config);

        StringEntity entity=new StringEntity(param.toString(),"utf-8");
        //封装请求头，把map格式遍历出来
       // Set<Map.Entry<String,String>> headMap=headers.entrySet();
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
            throw new RuntimeException("doPostWithJson方法运行异常..."+url);
        }

    }

    /**
     * 普通post请求,key-value
     * @param url
     * @param param
     * @return
     */
    public static String doPostWithKeyValue(String url,JSONObject param,Map<String,String> headers){

        HttpPost post=new HttpPost(url);
        CloseableHttpClient client=HttpClients.createDefault();
        RequestConfig config = RequestConfig.custom()
                .setConnectTimeout(CONNECTION_TIMEOUT)
                .setConnectionRequestTimeout(REQUEST_TIMEOUT)
                .setSocketTimeout(SOCKET_TIMEOUT)
                .build();
        post.setConfig(config);
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
            UrlEncodedFormEntity entity=new UrlEncodedFormEntity(list,Consts.UTF_8);
            post.setEntity(entity);

            HttpResponse response=client.execute(post);
            resultCode=response.getStatusLine().getStatusCode();
            String result=EntityUtils.toString(response.getEntity(),Consts.UTF_8);
            return result;

        } catch (Exception e) {
            throw new IllegalArgumentException("doPostWithKeyValue方法运行异常..."+url);
        }
    }


    /**
     * get请求,需要请求头，无参数
     * @param   url
     * @return
     */
    public static String doGetWithHeads(String url,Map<String,String> headers){

        HttpGet get=new HttpGet(url);
        CloseableHttpClient client=HttpClients.createDefault();
        RequestConfig config = RequestConfig.custom()
                .setConnectTimeout(CONNECTION_TIMEOUT)
                .setConnectionRequestTimeout(REQUEST_TIMEOUT)
                .setSocketTimeout(SOCKET_TIMEOUT)
                .build();
        get.setConfig(config);
        //封装请求头
        for (Map.Entry<String, String> header : headers.entrySet()){
            get.setHeader(header.getKey(),header.getValue());
        }

        try {
            HttpResponse response=client.execute(get);
            resultCode=response.getStatusLine().getStatusCode();
            String result=EntityUtils.toString(response.getEntity(),"utf-8");
            return result;
        } catch (IOException e) {
            throw new IllegalArgumentException("doGetWithHeads方法运行异常..."+url);
        }
    }









    /**
     * 替换模版参数
     * @param bodyPattern
     * @param param
     * @return
     */
    public static String makeParamter(String bodyPattern, Map<String, String> param, HashMap<String, String> converMap) {
        if(StringUtils.isEmpty(bodyPattern)){
            return null;
        }
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
