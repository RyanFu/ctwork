package com.example.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;

/**
 * @author yicg
 * @createTime 2020年01月15日 10:26:00
 * @Description
 *
 * 读取json文件
 */
public class JsonReadUtils {

    private static final Logger logger = LoggerFactory.getLogger(JsonReadUtils.class);

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
            Reader reader = new InputStreamReader(new FileInputStream(jsonFile), "utf-8");
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
            logger.info("读取文件出现异常，读取失败!==>"+jsonFile.getName());
            e.printStackTrace();
            return null;
        }
    }

}
