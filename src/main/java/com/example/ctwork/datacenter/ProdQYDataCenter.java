package com.example.ctwork.datacenter;

import com.alibaba.fastjson.JSON;
import com.example.common.Const;
import com.example.util.ExcelReaderUtils;
import com.example.util.HttpClientUtils;
import com.example.util.JsonReadUtils;
import com.example.util.RandomUtils;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author yicg
 * @createTime 2020年01月14日 11:53:00
 * @Description  迁移数据线上回归
 */

public class ProdQYDataCenter {

    private static Logger logger=LoggerFactory.getLogger(ProdQYDataCenter.class);

    //同盾字段请求参数json地址
    public static String TD_PARAM_JSON=Const.TD_PROD_JSON_PATH;


    /**
     * 读取excel文件
     */
    @DataProvider(name = "excel")
    public Object[][] excelFile() {
        // 测试数据准备
        String file = Const.QY_DATA_CENTER__PATH;

       // Object[][] records=ExcelReaderUtils.getExpectationData(file,"优分");
        Object[][] records=ExcelReaderUtils.getExpectationData(file,"同盾");

        return records ;
    }


    @Test(dataProvider = "excel")
    public void QYDataCenterRead(String var_name,String desc) {
        Map<String, String> headers = new HashMap<>();
        headers.put("Content-Type", "application/json");

        com.alibaba.fastjson.JSONObject jsonObject =JsonReadUtils.readJsonFile(TD_PARAM_JSON);
        jsonObject.put("fields",var_name);

        String response = HttpClientUtils.postMethod(Const.pro_wj_data_center_url, jsonObject, headers);
        com.alibaba.fastjson.JSONObject json=JSON.parseObject(response);

        logger.info(var_name +"--"+desc+"---->" + json.get("data"));

    }

}
