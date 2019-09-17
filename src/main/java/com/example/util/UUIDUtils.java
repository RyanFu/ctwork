package com.example.util;

import java.util.UUID;

/**
 * @Author: yicg
 * @Date: 2019/4/22 10:38
 * @Version 1.0
 */
public class UUIDUtils {
    public static String getUUID(){
        return UUID.randomUUID().toString().replace("-", "");
    }

}
