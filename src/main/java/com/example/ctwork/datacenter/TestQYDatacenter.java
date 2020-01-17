package com.example.ctwork.datacenter;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.common.Const;
import com.example.util.ExcelReaderUtils;
import com.example.util.HttpClientUtils;

import com.example.util.JsonReadUtils;
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
       // Object[][] records=ExcelReaderUtils.getExpectationData(file,"优分");
        Object[][] records=ExcelReaderUtils.getExpectationData(file,"同盾");
        logger.info(records.toString());
        return records ;
    }

    @Test(dataProvider = "excel")
    public void QYDataCenterRead(String var_name,String desc) {
        Map<String, String> headers = new HashMap<>();
        headers.put("Content-Type", "application/json");

        JSONObject jsonObject =JsonReadUtils.readJsonFile(Const.TD_TEST_JSON_PATH);
        jsonObject.put("fields",var_name);

        String response = HttpClientUtils.postMethod(Const.test_wj_data_center_url, jsonObject, headers);
        JSONObject json=JSON.parseObject(response);
        logger.info(var_name +"--"+desc+"---->" + json.getString("data"));

    }
}
