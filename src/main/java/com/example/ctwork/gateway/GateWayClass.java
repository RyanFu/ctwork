package com.example.ctwork.gateway;

import com.example.util.HttpClientUtils;
import com.example.util.MapUtils;

import org.json.JSONObject;
import org.testng.annotations.Test;


/**
 * gateway相关接口
 */
public class GateWayClass {

    // 墨智请求url
    private final  String mzUrl="http://192.168.10.247:8092/data-gateway/api/v1/service?cacheType=N&serviceCode=MOZHI_NEW&partnerId=WUJ01";

    //百行征信url
    private final  String BHUrl="http://10.61.10.243:8092/data-gateway/api/v1/service?cacheType=Y&serviceCode=BAIHANG_CREDIT&partnerId=WUJ01";

    /**
     * 墨智数据源 新(云真信)
     */
    @Test
    public void MoZhiTest(){
        JSONObject jsonObject=new JSONObject();
        jsonObject.put("phone","17783470157");

        String result=HttpClientUtils.postMethod(mzUrl,jsonObject,MapUtils.HeadersMap());
        JSONObject jsonResult=new JSONObject(result);

        System.out.println(jsonResult);

    }

    /**
     * 百行征信gateway
     */
    @Test
    public void BHTest(){

        JSONObject jsonObject=new JSONObject();
        jsonObject.put("name","伊春光");
        jsonObject.put("pid","41282719910222579X");
        jsonObject.put("mobile","15317063103");
        jsonObject.put("queryReason",6);

        String result =HttpClientUtils.postMethod(BHUrl,jsonObject,MapUtils.HeadersMap());
        System.out.println(result);
    }


}
