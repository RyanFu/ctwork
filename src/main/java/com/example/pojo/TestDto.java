package com.example.pojo;

import com.alibaba.fastjson.JSONObject;
import lombok.Data;


@Data
public class TestDto {

    private String caseName;

    private String host;

    private int port;

    private String uri;

    private String method;

    /**
     * 请求头信息
     */
    private JSONObject headMap;


    /**
     * 请求参数对象
     */
    private JSONObject paramMap;

    private String paramType;

    /**
     * 期望结果
     */
    private String expectedResult;

    /**
     * 实际结果
     */
    private String actualResult;

}
