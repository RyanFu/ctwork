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
    //测试地址
    private static String URL=Const.TEST_WJ_DATA_CENTER_URL;


    //sheet7字段和参数
    public static String TEST_PARAM_SHEET_007=Const.TEST_SHEET_007;
    public static String FILE_NAME_SHEET_007="sheet7";

    //sheet8字段和参数
    public static String TEST_PARAM_SHEET_008=Const.TEST_SHEET_008;
    public static String FILE_NAME_SHEET_008="颜值贷0304";

    //sheet9字段和参数
    public static String TEST_PARAM_SHEET_009=Const.TEST_SHEET_009;
    public static String FILE_NAME_SHEET_009="好多数等三方数据字段";


    /**
     * 读取excel文件
     */
    @DataProvider(name = "excel")
    public Object[][] excelFile() {
        // 测试数据准备
        String file = Const.QY_DATA_CENTER__PATH;
        Object[][] records=ExcelReaderUtils.getExpectationData(file,FILE_NAME_SHEET_009);
        logger.info(records.toString());
        return records ;
    }

    @Test(dataProvider = "excel")
    public void QYDataCenterRead(String var_name,String desc) {
        Map<String, String> headers = new HashMap<>();
        headers.put("Content-Type", "application/json");

        JSONObject jsonObject =JsonReadUtils.readJsonFile(TEST_PARAM_SHEET_009);
        jsonObject.put("fields",var_name);

        String response = HttpClientUtils.postMethod(URL, jsonObject, headers);
        JSONObject json=JSON.parseObject(response);
        logger.info(var_name +"--"+desc+"---->" + json.getString("data"));

    }
}
