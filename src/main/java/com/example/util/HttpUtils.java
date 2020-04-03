package com.example.util;

import lombok.extern.slf4j.Slf4j;



/**
 * Http工具类
 */
@Slf4j
public class HttpUtils {



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
