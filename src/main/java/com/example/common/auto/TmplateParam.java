package com.example.common.auto;

import com.alibaba.fastjson.JSONObject;
import com.example.common.Const;
import com.example.util.JsonReadUtils;
import com.google.common.collect.Maps;

import java.util.Map;

/**
 * @author yicg
 * @createTime 2020年03月20日 10:43:00
 * @Description   auto_test_case表中模版参数
 */
public class TmplateParam {



    public static  Map<String, String> tmpParam(){
        Map<String, String> parm=Maps.newHashMap();
        parm.put(InPutFieldCodeEnum.USERNAME.name(),"wangwua");
        parm.put(InPutFieldCodeEnum.PASSWORD.name(),"wangwua123");
        return parm;

      }






      //从文件里读取参数
      public static String getValue(String key){

        String path=Const.BASE_PATH+"/src/main/json/gateway_param.json";
        JSONObject jsonObject=JsonReadUtils.readJsonFile(path);
        JSONObject inFields=jsonObject.getJSONObject("inFields");
        return inFields.getString(key);
      }

}
