package com.example.pojo;

import com.alibaba.fastjson.JSONObject;
import lombok.Data;
import java.util.Date;


@Data
public class AutoTestCase {

    private Integer id ;

    private String caseName;

    private String host;

    private int port;

    private String uri;

    private String method;

    private String heads;

    private String paramType;

    private String param;

    private String state;

    /**
     * 实际结果
     */
    private String actualResult;

    private Date creatTime;

    private Date updateTime;


}
