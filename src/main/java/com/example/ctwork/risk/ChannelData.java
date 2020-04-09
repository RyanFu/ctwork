package com.example.ctwork.risk;


import com.example.common.Const;
import com.example.util.ExcelReaderUtils;
import com.example.util.HttpClientUtils;
import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;



//  uid
@Slf4j
public class ChannelData {

    //测试地址
    private static String URL="http://127.0.0.1:8086/update/all?uid=";



    /**
     * 读取excel文件
     */
    @DataProvider(name = "chanel")
    public Object[][] excelFile() {
        // 测试数据准备
        String file =Const.QY_DATA_CENTER__PATH;
        Object[][] records=ExcelReaderUtils.getExpectationData(file,"chanel");
        log.info(records.toString());
        return records ;
    }


    @Test(dataProvider = "chanel")
    public void QYDataCenterRead(String uid) {
        Map<String, String> headers = new HashMap<>();
        headers.put("Content-Type", "application/json");
        String result=HttpClientUtils.doGetOnlyUrl(URL+uid);

    }
}
