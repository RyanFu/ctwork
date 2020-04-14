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


/**
 * @author yicg
 * risk环境数尊进件
 */
@Slf4j
public class TestRiskBod {

    //测试地址
    //private static String URL=Const.TEST_WJ_DATA_CENTER_URL;
    private static String URL="http://risk-fk.stage.ndmicro.net/api/decision/simpleResultsAsnyc";


    //sheet8字段和参数
    public static String TEST_PARAM_SHEET_008="/Users/yicg/IdeaProjects/ctwork/src/main/json/test_risk_bod.json";
    public static String FILE_NAME_SHEET_008="chaneldata";



    /**
     * 读取excel文件
     */
    @DataProvider(name = "excel")
    public Object[][] excelFile() {
        // 测试数据准备
        String file = Const.QY_DATA_CENTER__PATH;
        Object[][] records=ExcelReaderUtils.getExpectationData(file,FILE_NAME_SHEET_008);
        log.info(records.toString());
        return records ;
    }

    @Test(dataProvider = "excel")
    public void QYDataCenterRead(String idcard,String name,String mobil) {
        Map<String, String> headers = new HashMap<>();
        headers.put("Content-Type", "application/json");

        JSONObject jsonObject =JsonReadUtils.readJsonFile(TEST_PARAM_SHEET_008);
        JSONObject inFields=jsonObject.getJSONObject("inFields");
        inFields.put("PHONENO",mobil);
        inFields.put("USERNAME",name);
        inFields.put("USERIDNUMBER",idcard);

        String response = HttpClientUtils.doPostWithJson(URL, jsonObject, headers);
        JSONObject json=JSON.parseObject(response);
        log.info(idcard +"--"+name+"---->");

    }
}
