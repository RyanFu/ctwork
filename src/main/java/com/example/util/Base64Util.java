package com.example.util;

import org.springframework.util.Base64Utils;

import java.security.NoSuchAlgorithmException;

/**
 * @author yicg
 * @createTime 2020年05月06日 15:31:00
 * @Description  Base64加解密
 */
public class Base64Util {
    /**
     * BASE64加密
     * @param key 加密前的字符串
     * @return
     * @throws Exception
     */
    public static String encryptBASE64(String key) {
        byte[] bytes=null;
        try {
            bytes=key.getBytes();
            return new String(Base64Utils.encode(bytes));
        }catch (Exception e){
            throw new RuntimeException("Base64加密异常"+e);
        }
    }

    /**
     * BASE64解密
     *
     * @param resultKey 加密后的key
     * @return
     * @throws Exception
     */
    public static String decryptBASE64(String resultKey) {
        byte[] bytes=null;
        try {
            bytes=resultKey.getBytes();
            return new String(Base64Utils.decode(bytes));
        }catch (Exception e){
            throw new RuntimeException("Base64解密异常"+e);
        }
    }
}
