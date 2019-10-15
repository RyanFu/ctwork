package com.example.pojo;

import lombok.Data;

import java.util.Date;
import java.util.Map;

@Data
public class TestDto {

    private Integer id ;

    private String caseName;

    private String url;

    private String method;

    private String param;

    /**
     * 请求头信息
     */
    private Map<String,Object> headMap;

    private String state;

    private Date creatTime;

    private Date updateTime;

    /**
     * 请求参数对象
     */
    private Map<String,Object> paramMap;



}
