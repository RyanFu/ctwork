package com.example.ctwork.datacenter;
import com.example.common.Const;
import com.example.util.ExcelReaderUtils;
import com.example.util.HttpClientUtils;

import com.example.util.RandomUtils;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;


//崇天迁移无界测试
public class TestQYDatacenter {

    private static Logger logger=LoggerFactory.getLogger(TestQYDatacenter.class);

    /**
     * 读取excel文件
     */
    @DataProvider(name = "excel")
    public Object[][] excelFile() {
        // 测试数据准备
        String file = Const.QY_DATA_CENTER__PATH;
        Object[][] records=ExcelReaderUtils.getExpectationData(file,"优分");
        //Object[][] records=ExcelReaderUtils.getExpectationData(file,"同盾");
        logger.info(records.toString());
        return records ;
    }

    //参数,基本三要素
    String s="{\"inFields\":{\"PHONENUM\":\"18860135080\",\"IDCARD\":\"350122199105055222\",\"NAME\":\"陈倩倩\"}}";


    JSONObject jsonObject=new JSONObject(s);
    JSONObject inFields= (JSONObject) jsonObject.get("inFields");
    String NAME= (String) inFields.get("NAME");
    String IDCARD= (String) inFields.get("IDCARD");
    String PHONENUM= (String) inFields.get("PHONENUM");


    @Test(dataProvider = "excel")
    public void QYDataCenterRead(String var_name,String desc) {
        Map<String, String> headers = new HashMap<>();
        headers.put("Content-Type", "application/json");

        JSONObject jsonObject = new JSONObject();
        JSONObject object = new JSONObject();
        jsonObject.put("UID", "2A5A559A74E656C3BA2AD33F8B0C4503");
        jsonObject.put("TRAFFIC", "cl_drawInstallment");
        jsonObject.put("PRODUCT", "NCP1");
        jsonObject.put("TRAFFIC_CODE", "cl_drawInstallment");
        jsonObject.put("PHONENUM", PHONENUM);
        jsonObject.put("IDCARD", IDCARD);
        jsonObject.put("CONTACTPHONENUMS", PHONENUM);
        jsonObject.put("CONTACNAME", NAME);
        jsonObject.put("NAME", NAME);
        jsonObject.put("TYPE", 1);
        jsonObject.put("IP", "127.0.0.1");
        jsonObject.put("CYCLE", "6");
        jsonObject.put("LOANTYPE", "2");
        jsonObject.put("TID", "30628b47bfd04eb08dcb95037ebc56ee");

        String pid = String.valueOf(RandomUtils.getRandomCode());
        object.put("inFields", jsonObject);
        object.put("pid", RandomUtils.getRandomCode());
        object.put("uid", "2A5A559A74E656C3BA2AD33F8B0C4503");
        object.put("organId", "12311");
        object.put("fields", var_name);


        String response = HttpClientUtils.postMethod(Const.test_ct_data_center_url, object, headers);

        JSONObject json = new JSONObject(response);

        logger.info(var_name + "---->" + json.get("data"));

    }
}
