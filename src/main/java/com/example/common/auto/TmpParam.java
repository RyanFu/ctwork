package com.example.common.auto;

import com.alibaba.fastjson.JSONObject;
import com.example.common.Const;
import com.example.util.JsonReadUtils;
import com.google.common.collect.Maps;

import java.util.Map;

/**
 * @author yicg
 * @createTime 2020年03月20日 10:43:00
 * @Description   gateway模版参数
 */
public class TmpParam {



    public static  Map<String, String> tmpParam(){
        Map<String, String> parm=Maps.newHashMap();
       // parm.put(InPutFieldCode.USERNAME.name(),getValue("IDCARD"));
        //parm.put(InPutFieldCode.PASSWORD.name(),getValue("PHONENUM"));

        parm.put(InPutFieldCode.USERNAME.name(),"wangwua");
        parm.put(InPutFieldCode.PASSWORD.name(),"wangwua123");


        return parm;

      }



      public static String getValue(String key){

        String path=Const.BASE_PATH+"/src/main/json/gateway_param.json";
        JSONObject jsonObject=JsonReadUtils.readJsonFile(path);
        JSONObject inFields=jsonObject.getJSONObject("inFields");
        return inFields.getString(key);
      }

}
