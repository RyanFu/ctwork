package com.example.ctwork.risk;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.common.Const;
import com.example.util.ExcelReaderUtils;
import com.example.util.HttpClientUtils;
import com.example.util.JsonReadUtils;
import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;


//崇天迁移无界测试
@Slf4j
public class Channel {

    //测试地址
    private static String URL="http://192.168.10.120:9000/api/decision/simpleResultsAsnyc";



    /**
     * 读取excel文件
     */
    @DataProvider(name = "chanel")
    public Object[][] excelFile() {
        // 测试数据准备
        String file =Const.QY_DATA_CENTER__PATH;
        Object[][] records=ExcelReaderUtils.getExpectationData(file,"chaneldata");
        log.info(records.toString());
        return records ;
    }


    @Test(dataProvider = "chanel")
    public void QYDataCenterRead(String uid,String id_card_no,String user_name,String mobile_no) {
        Map<String, String> headers = new HashMap<>();
        headers.put("Content-Type", "application/json");

        JSONObject jsonObject =JsonReadUtils.readJsonFile(Const.TEST_SHEET_010);
        JSONObject inFields=jsonObject.getJSONObject("inFields");
        inFields.put("PHONENO",mobile_no);
        inFields.put("USERNAME",user_name);
        inFields.put("USERIDNUMBER",id_card_no);
        inFields.put("UID",uid);

        jsonObject.put("uid",uid);
        jsonObject.put("pid",UUID.randomUUID());

        System.out.println(inFields);
        String response = HttpClientUtils.doPostWithJson(URL, jsonObject, headers);
        JSONObject json=JSON.parseObject(response);


    }
}
