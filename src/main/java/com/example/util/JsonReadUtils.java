package com.example.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;

import java.io.*;

/**
 * @author yicg
 * @createTime 2020年01月15日 10:26:00
 * @Description
 *
 * 读取json文件
 */
@Slf4j
public class JsonReadUtils {


    /**
     * 读取json文件
     * @param
     * @return 返回json字符串
     */
    public static JSONObject readJsonFile(String path) {
        String jsonStr = "";
        File jsonFile = new File(path);
        try {
            FileReader fileReader = new FileReader(jsonFile);
            Reader reader = new InputStreamReader(new FileInputStream(jsonFile), "UTF-8");
            int ch = 0;
            StringBuffer sb = new StringBuffer();
            while ((ch = reader.read()) != -1) {
                sb.append((char) ch);
            }
            fileReader.close();
            reader.close();
            jsonStr = sb.toString();
            JSONObject jsonObject=JSON.parseObject(jsonStr);
            return jsonObject;
        } catch (Exception e) {
            log.info("读取文件出现异常，读取失败!==>"+jsonFile.getName());
            e.printStackTrace();
            return null;
        }
    }


}
