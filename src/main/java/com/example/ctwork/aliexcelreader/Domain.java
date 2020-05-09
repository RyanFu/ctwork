package com.example.ctwork.aliexcelreader;

import lombok.Data;

/**
 * @author yicg
 * @createTime 2020年05月07日 13:34:00
 * @Description  待读取excel的参数
 */
@Data
public class Domain {

    private String varName;
    private String desc;
    private String externalId;
    private String idNumber;
    private String name;
    private String mobileNumber;
}
