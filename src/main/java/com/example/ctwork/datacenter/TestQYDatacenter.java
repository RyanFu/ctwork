package com.example.ctwork.datacenter;
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


/**
 * 崇天迁移无界测试
 * @author yicg
 */
@Slf4j
public class TestQYDatacenter {

    /**
     * 测试地址
     */
    private static String URL=Const.TEST_WJ_DATA_CENTER_URL;



    /**
     * sheet9字段和参数
     */
    public static String TEST_PARAM_SHEET_001=Const.TEST_SHEET_001;
    public static String FILE_NAME_SHEET_001="三方字段";



    /**
     * 读取excel文件
     */
    @DataProvider(name = "excel")
    public Object[][] excelFile() {
        // 测试数据准备
        String file = Const.QY_DATA_CENTER__PATH;
        Object[][] records=ExcelReaderUtils.getExpectationData(file,FILE_NAME_SHEET_001);
        log.info(records.toString());
        return records ;
    }

    @Test(dataProvider = "excel")
    public void QYDataCenterRead(String var_name,String desc) {
        Map<String, String> headers = new HashMap<>();
        headers.put("Content-Type", "application/json");

        JSONObject jsonObject =JsonReadUtils.readJsonFile(TEST_PARAM_SHEET_001);
        jsonObject.put("fields",var_name);

        String response = HttpClientUtils.doPostWithJson(URL, jsonObject, headers);
        JSONObject json=JSON.parseObject(response);
        String res=json.getString("data");
        log.info(var_name+" "+desc+" "+res);
    }
}
