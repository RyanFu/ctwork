package com.example.util;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: yicg
 * @Date: 2019/7/2 17:46
 * @Version 1.0
 */
public class MapUtils {

    /**
     * 请求头工具类
     * 包含Content-Type头信息
     * @return
     */
    public static Map<String,String> HeadersMap(){
        Map<String,String> headers=new HashMap<>();
        headers.put("Content-Type","application/json");

        return headers;
    }
}
