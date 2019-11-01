package com.example.ctwork;
import com.example.common.Const;
import com.example.util.HttpClientUtils;

import com.example.util.RandomUtils;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;


public class EcxelTest {

    public final String url="http://192.168.10.247:8083/field/search";
    public final String data_center_url="http://192.168.10.247:8091/api/datacenter";
    private static Logger logger=LoggerFactory.getLogger(EcxelTest.class);


    /**
     * 读取excel文件
     */
    @DataProvider(name = "excel")
    public Object[][] excelFile() {
        // 测试数据准备
        String file = Const.DATA_CENTER__PATH;
        Object[][] records=ExcelReader.getExpectationData(file, "sheet1");
        logger.info(records.toString());
        return records ;
    }




    //@Test(dataProvider = "excel")
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


    @Test(dataProvider = "excel")
    public void dataCenterRead(String var_name){
        Map<String,String> headers=new HashMap<>();
        headers.put("Content-Type","application/json");

        JSONObject jsonObject=new JSONObject();
        JSONObject object=new JSONObject();
        jsonObject.put("UID","2A5A559A74E656C3BA2AD33F8B0C4503");
        jsonObject.put("TRAFFIC","NCP1");
        jsonObject.put("PRODUCT","cl_drawInstallment");
        jsonObject.put("TRAFFIC_CODE","cl_drawInstallment");
        jsonObject.put("PHONENUM","17782032814");
        jsonObject.put("IDCARD","500233199603150727");
        jsonObject.put("CONTACTPHONENUMS","17782032814");
        jsonObject.put("CONTACNAME","秦宗梅");
        jsonObject.put("NAME","秦宗梅");
        jsonObject.put("TYPE",1);
        jsonObject.put("IP","127.0.0.1");
        jsonObject.put("CYCLE","6");
        jsonObject.put("LOANTYPE","2");
        jsonObject.put("TID","5f0a7dc291ec407f90bbe2d60f0498c6");

        String pid= String.valueOf(RandomUtils.getRandomCode());
        object.put("inFields",jsonObject);
        object.put("pid",RandomUtils.getRandomCode());
        object.put("uid","2A5A559A74E656C3BA2AD33F8B0C4503");
        object.put("organId","34567543");
        object.put("fields",var_name);


       String result= HttpClientUtils.postMethod(data_center_url,object,headers);

       JSONObject json=new JSONObject(result);

        logger.info(var_name+"--"+pid+"---->"+json.get("data"));

    }
}
