package com.example.dto;

import lombok.Data;
import org.json.JSONObject;

/**
 * @author yicg
 * @createTime 2020年03月20日 11:12:00
 * @Description
 */
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
