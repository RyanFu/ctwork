package com.example.util;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.Consts;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author yicg
 * @createTime 2020年05月13日 14:00:00
 * @Description
 */
@Slf4j
public class TestUtils {
    //连接超时时间
    private static final int CONNECTION_TIMEOUT=10000;
    //从连接池中取的连接的最长时间
    private static final int REQUEST_TIMEOUT=10000;
    //数据传输的超时时间
    private static final int SOCKET_TIMEOUT=10000;


    /**
     * 带参数get,可添加请求头，如果不需要携带请求投，参数传入new HashMap<>()即可
     * @param url
     * @param param
     * @return
     */
    public static String httpGetWithParamsAndHeads(String url, JSONObject param, Map<String,String> heads) throws IOException {
        CloseableHttpClient httpClient= HttpClients.createDefault();
        RequestConfig config= RequestConfig.custom()
                .setConnectTimeout(CONNECTION_TIMEOUT)
                .setSocketTimeout(SOCKET_TIMEOUT)
                .setConnectionRequestTimeout(REQUEST_TIMEOUT)
                .build();
       //封装请求参数
        List<NameValuePair> list=new ArrayList<>();
       for (String key:param.keySet()){
            list.add(new BasicNameValuePair(key,param.getString(key)));
       }
        String reqParam=EntityUtils.toString(new UrlEncodedFormEntity(list,Consts.UTF_8));
        HttpGet get=new HttpGet(url+"?"+reqParam);
        get.setConfig(config);
        //封装请求头
        for (Map.Entry<String, String> map : heads.entrySet()) {
            get.addHeader(map.getKey(), map.getValue());
        }
        HttpResponse response=httpClient.execute(get);
        String result= EntityUtils.toString(response.getEntity(), Consts.UTF_8);
        return result;
    }



    public static void main(String[] args) throws IOException {
        String url1="http://localhost:8088/auto/test";
        JSONObject param1=new JSONObject();
        param1.put("id",16);
        String res= httpGetWithParamsAndHeads(url1,param1,new HashMap<>());
        System.out.println(res);
    }
}



