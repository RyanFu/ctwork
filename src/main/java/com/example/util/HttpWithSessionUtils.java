package com.example.util;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.Consts;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.CookieStore;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author yicg
 * @createTime 2020年04月14日 13:33:00
 * @Description  依赖cookies/生成cookies的方法
 */
@Slf4j
public class HttpWithSessionUtils {
    /**
     * 登录成功生成的session
     */
    public static CookieStore cookieStore;

    /**
     * httpclient返回状态码
     */
    public static int resultCode;

    //连接超时时间
    private static final int CONNECTION_TIMEOUT=10000;
    //从连接池中取的连接的最长时间
    private static final int REQUEST_TIMEOUT=10000;
    //数据传输的超时时间
    private static final int SOCKET_TIMEOUT=10000;




    /**
     * 普通post请求,key-value,生成session
     * @param url
     * @param param  com.alibaba.fastjson.JSONObject实现了Map，可以使用map下的方法
     * @return
     */
    public static String doPostWithKeyValueGetSession(String url, JSONObject param, Map<String,String> headers){
        //设置cookieStore
        cookieStore = new BasicCookieStore();
        CloseableHttpClient client = HttpClients.custom().setDefaultCookieStore(cookieStore).build();
        RequestConfig config = RequestConfig.custom()
                .setConnectTimeout(CONNECTION_TIMEOUT)
                .setConnectionRequestTimeout(REQUEST_TIMEOUT)
                .setSocketTimeout(SOCKET_TIMEOUT)
                .build();
        HttpPost post=new HttpPost(url);
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
            UrlEncodedFormEntity entity=new UrlEncodedFormEntity(list,Consts.UTF_8);
            post.setEntity(entity);
            post.setConfig(config);
            HttpResponse response=client.execute(post);
            String result=EntityUtils.toString(response.getEntity(),Consts.UTF_8);
            resultCode=response.getStatusLine().getStatusCode();
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
        //设置cookieStore
        CloseableHttpClient client = HttpClients.custom().setDefaultCookieStore(cookieStore).build();
        RequestConfig config = RequestConfig.custom()
                .setConnectTimeout(CONNECTION_TIMEOUT)
                .setConnectionRequestTimeout(REQUEST_TIMEOUT)
                .setSocketTimeout(SOCKET_TIMEOUT)
                .build();

        try {
            HttpGet get=new HttpGet(url);
            get.setConfig(config);
            log.info("接口发送COOKIES:{}",cookieStore);
            HttpResponse httpResponse=client.execute(get);
            String result=EntityUtils.toString(httpResponse.getEntity(),Consts.UTF_8);
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

        //设置cookieStore
        CloseableHttpClient client = HttpClients.custom().setDefaultCookieStore(cookieStore).build();
        RequestConfig config = RequestConfig.custom()
                .setConnectTimeout(CONNECTION_TIMEOUT)
                .setConnectionRequestTimeout(REQUEST_TIMEOUT)
                .setSocketTimeout(SOCKET_TIMEOUT)
                .build();
        //封装请求参数
        List<NameValuePair> list = new ArrayList<NameValuePair>();
        for (String key : param.keySet()) {
            list.add(new BasicNameValuePair(key, String.valueOf(param.get(key))));
        }
        try {
            String requestParams=EntityUtils.toString(new UrlEncodedFormEntity(list, Consts.UTF_8));
            HttpGet get=new HttpGet(url+"?"+requestParams);
            get.setConfig(config);
            log.info("get请求数据:{}",url+"?"+requestParams);
            HttpResponse httpResponse=client.execute(get);
            String result=EntityUtils.toString(httpResponse.getEntity(),Consts.UTF_8);
            resultCode=httpResponse.getStatusLine().getStatusCode();
            return result;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }


}
