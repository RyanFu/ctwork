package com.example.util;


import com.google.gson.Gson;

import java.util.Map;

/**
 * json转换工具类
 */
public class JsonUtils {

    /**
     * 把String格式的参数转化为Map格式   {"password":"wangwua123","username":"wangwua"}===>Map
     */

    public static Map<String , Object> stringToJson(String jsonData){
        return  new Gson().fromJson(jsonData , Map.class);
    }

}
