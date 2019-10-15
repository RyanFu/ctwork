package com.example.pojo;

import lombok.Data;
import java.util.Date;


@Data
public class AutoTestCase {

    private Integer id ;

    private String caseName;

    private String url;

    private String method;

    private String param;

    private String heads;

    private String state;

    private Date creatTime;

    private Date updateTime;


}
