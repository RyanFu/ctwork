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

    public static int resultCode;

    /**
     * 请求方式判断
     */
    private static final String GET_METHOD="GET";
    private static final String POST_METHOD="POST";



    /**
     * 100:普通post请求，application/json请求，不需要cookies
     *
     * 101:普通post请求，key-value请求，访问成功后生成cookies
     *
     * 200:普通get请求，无参数访问，依赖cookies
     * 201:普通get请求，需要参数?key=value
     */
    private static final String PARAM_TYPE_100 ="100";
    private static final String PARAM_TYPE_101 ="101";
    private static final String PARAM_TYPE_200 ="200";
    private static final String PARAM_TYPE_201 ="201";



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

        //判断参数是否为空
        JSONObject requestBody=null;
        if(! StringUtils.isEmpty(requestParam)){
            //通过模版映射的请求参数
            String reqBody = HttpClientUtils.makeParamter(requestParam, TmplateParam.tmpParam(), AutoTestCaseFeatureComponent.paramMap);
            requestBody = JSON.parseObject(reqBody);
        }
        //获取请求头
        Map<String,String> headMap=requestHead(heads);
        if(StringUtils.isEmpty(port)){
            url=host+uri;
        }if(!StringUtils.isEmpty(port)) {
            url=host+":"+port+uri;
        }

        //请求方式  POST/GET
        String method=testCase.getMethod();
        //请求类型：100.json   2.key-value
        String param_type=testCase.getParamType();
        String response="";

        //判断请求方式为post
        if(POST_METHOD.equals(method)){
            if(PARAM_TYPE_100.equals(param_type)){
                response=HttpClientUtils.doPostWithJson(url,requestBody,headMap);
                resultCode=HttpClientUtils.resultCode;
              log.info("请求地址:{},请求参数:{},返回结果:{}",url,requestBody,JSON.parseObject(response));
            } if(PARAM_TYPE_101.equals(param_type)){
              response= HttpForSessionUtils.doPostWithKeyValueGetSession(url,requestBody,headMap);
              resultCode=HttpForSessionUtils.resultCode;
              log.info("请求地址:{},请求参数:{},返回结果:{}",url,requestBody,JSON.parseObject(response));
            }
        }
        //判断请求方式为get
        if(GET_METHOD.equals(method)){
            if(PARAM_TYPE_200.equals(param_type)){
               response=HttpForSessionUtils.doGetOnlyUrlWithSession(url);
               resultCode=HttpForSessionUtils.resultCode;
               log.info("请求地址:{},返回结果:{}",url,JSON.parseObject(response));
            }if(PARAM_TYPE_201.equals(param_type)){
                response=HttpForSessionUtils.doGetWithParamsWithSession(url,requestBody);
                resultCode=HttpForSessionUtils.resultCode;
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
