package com.example.ctwork.datacenter;

import com.alibaba.fastjson.JSON;
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

/**
 * @author yicg
 * @createTime 2020年01月14日 11:53:00
 * @Description  迁移数据线上回归
 *
 */

public class ProdQYDataCenter {

    private static Logger logger=LoggerFactory.getLogger(ProdQYDataCenter.class);
    //线上地址
    private static String URL=Const.PRO_WJ_DATA_CENTER_URL;

    //sheet3字段和参数
    public static String PROD_PARAM_SHEET_003=Const.PROD_SHEET_003;
    public static String FILE_NAME_SHEET_003="同盾003";


    //sheet4字段和参数
    public static String PROD_PARAM_SHEET_004=Const.PROD_SHEET_004;
    public static String FILE_NAME_SHEET_004="本地字段004";

    //sheet5字段和参数
    public static String PROD_PARAM_SHEET_005=Const.PROD_SHEET_005;
    public static String FILE_NAME_SHEET_005="迁移字段005";

    //sheet6字段和参数
    public static String PROD_PARAM_SHEET_006=Const.PROD_SHEET_006;
    public static String FILE_NAME_SHEET_006="优分006";

    //sheet6字段和参数
    public static String PROD_PARAM_SHEET_007=Const.PROD_SHEET_007;
    public static String FILE_NAME_SHEET_007="sheet7";

    /**
     * 读取excel文件
     */
    @DataProvider(name = "excel")
    public Object[][] excelFile() {
        // 测试数据准备
        String file = Const.QY_DATA_CENTER__PATH;

        Object[][] records=ExcelReaderUtils.getExpectationData(file,FILE_NAME_SHEET_007);

        return records ;
    }


    @Test(dataProvider = "excel")
    public void QYDataCenterRead(String var_name,String desc) {
        Map<String, String> headers = new HashMap<>();
        headers.put("Content-Type", "application/json");

        com.alibaba.fastjson.JSONObject jsonObject =JsonReadUtils.readJsonFile(PROD_PARAM_SHEET_007);
        jsonObject.put("fields",var_name);

        String response = HttpClientUtils.postMethod(URL, jsonObject, headers);
        com.alibaba.fastjson.JSONObject json=JSON.parseObject(response);

        logger.info(var_name +"--"+desc+"---->" + json.get("data"));

    }

}
