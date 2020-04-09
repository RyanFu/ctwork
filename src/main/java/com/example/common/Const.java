package com.example.common;


public class Const {

    public static String BASE_PATH=System.getProperty("user.dir");
    //测试环境excel存放path
    public static final String XMLPATH=BASE_PATH+"/src/main/resources/ctWorkTestng.xml";


    //崇天和无界线上datacenter地址
    public static final String PRO_CT_DATA_CENTER_URL="http://datacenter.ndmicro.com/api/datacenter?cacheType=N";
    public static final String PRO_WJ_DATA_CENTER_URL="http://datacenter.91wujie.com/api/datacenter";

    //崇天和无界datacenter测试地址
    public static final String TEST_WJ_DATA_CENTER_URL="http://192.168.10.247:8091/api/datacenter";
    public static final String TEST_CT_DATA_CENTER_URL="http://192.168.10.237:8091/api/datacenter";



    //数据中心迁移数据excel存放路径
    public static final String QY_DATA_CENTER__PATH=BASE_PATH+"/src/main/TestData/数据迁移.xlsx";
    //测试地址参数存放地址
    public static final String TEST_SHEET_008=BASE_PATH+"/src/main/json/testparam/TEST_SHEET_008.json";
    public static final String TEST_SHEET_009=BASE_PATH+"/src/main/json/testparam/TEST_SHEET_009.json";
    //chanel-data
    public static final String TEST_SHEET_010=BASE_PATH+"/src/main/json/testparam/channel.json";




    //线上参数存放路径
    public static final String PROD_SHEET_008=BASE_PATH+"/src/main/json/prodparam/PROD_SHEET_008.json";
    public static final String PROD_SHEET_009=BASE_PATH+"/src/main/json/prodparam/PROD_SHEET_009.json";


}
