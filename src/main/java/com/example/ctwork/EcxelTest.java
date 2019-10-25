package com.example.ctwork;
import com.example.common.Const;
import com.example.util.HttpClientUtils;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;


public class EcxelTest {

    private final String url="http://192.168.10.247:8083/field/search";
    private static Logger logger=LoggerFactory.getLogger(EcxelTest.class);


    /**
     * 读取excel文件
     */
    @DataProvider(name = "excel")
    public Object[][] excelFile() {
        // 测试数据准备
        String file = Const.EXCEL_READ_PATH;
        Object[][] records=ExcelReader.getExpectationData(file, "sheet1");
        logger.info(records.toString());
        return records ;
    }




    @Test(dataProvider = "excel")
    public void excelRead(String custid ){

        Map<String,String> head=new HashMap<>();
        head.put("Content-Type","application/json");

        JSONObject jsonObject=new JSONObject();
      //  jsonObject.put("idCard",idcard);
      //  jsonObject.put("phoneNumber",phone);
        jsonObject.put("customerId",custid);
       // jsonObject.put("userName",);
      //  jsonObject.put("ip","127.0.0.1");
        jsonObject.put("fieldName","BSSID_IS_BLACK");

      String result=HttpClientUtils.postMethod(url,jsonObject,head);
        System.out.println("custId="+custid+"====>"+result);
    }
}
