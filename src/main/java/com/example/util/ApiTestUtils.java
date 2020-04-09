package com.example.util;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.common.auto.AutoTestCaseFeatureComponent;
import com.example.common.auto.TmplateParam;
import com.example.model.AutoTestCaseWithBLOBs;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.json.JSONArray;

import java.util.HashMap;
import java.util.Map;

/**
 * @author yicg
 * @createTime 2020年04月07日 17:05:00
 * @Description
 */
@Slf4j
public class ApiTestUtils{



    /**
     * 传入完整的case数据
     * @param testCase
     */
    public static String doHttpRequest(AutoTestCaseWithBLOBs testCase){
        String url="";
        String host=testCase.getHost();
        String uri=testCase.getUri();
        String port= String.valueOf(testCase.getPort());
        String heads=testCase.getHeads();
        String requestParam=testCase.getParam();

        //获取请求头
        Map<String,String> headMap=requestHead(heads);
        if(StringUtils.isEmpty(port)){
            url=host+uri;
        }if(!StringUtils.isEmpty(port)) {
            url=host+":"+port+uri;
        }
        //请求方式  POST/GET
        String method=testCase.getMethod();
        //请求类型：1.json   2.key-value
        String param_type=testCase.getParamType();

        String response="";


        if(method.equals("POST")){
            //通过模版映射的请求参数
            String reqBody = HttpClientUtils.makeParamter(requestParam, TmplateParam.tmpParam(), AutoTestCaseFeatureComponent.paramMap);
            JSONObject requestBody = JSON.parseObject(reqBody);

            //param_type  100:普通application/json请求，不需要cookies    200:key-value请求，访问成功后生成cookie
            if(param_type.equals("100")){
                response=HttpClientUtils.doPostWithJson(url,requestBody,headMap);

              log.info("请求地址:{},请求参数:{},返回结果:{}",url,reqBody,JSON.parseObject(response));
            } if(param_type.equals("200")){
              response= HttpClientUtils.doPostWithKeyValueGetSession(url,requestBody,headMap);
              log.info("请求地址:{},请求参数:{},返回结果:{}",url,reqBody,JSON.parseObject(response));
            }
        }
        if(method.equals("GET")){
            if(null ==requestParam){
               response=HttpClientUtils.doGetOnlyUrlWithSession(url);
               log.info("请求地址:{},返回结果:{}",url,JSON.parseObject(response));
            }
        }
        return response;

    }


    /**
     *  获取请求头
     * @param heads
     * @return
     */
    private static Map<String,String> requestHead(String heads){
        Map<String,String> header=new HashMap<>();
        if(! StringUtils.isEmpty(heads)){
            JSONArray jsonArray = new JSONArray(heads);
                for (int i=0;i<jsonArray.length();i++) {
                    org.json.JSONObject jsonObject= (org.json.JSONObject) jsonArray.get(i);
                    header.put(jsonObject.getString("key"),jsonObject.getString("value"));
                }
            log.info("请求头信息:{}",header);
            return header;
        }
       return null;
    }



}
