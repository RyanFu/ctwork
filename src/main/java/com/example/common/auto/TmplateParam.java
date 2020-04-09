package com.example.common.auto;

import com.alibaba.fastjson.JSONObject;
import com.example.common.Const;
import com.example.util.JsonReadUtils;
import com.google.common.collect.Maps;

import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;

/**
 * @author yicg
 * @createTime 2020年03月20日 10:43:00
 * @Description   auto_test_case表中模版参数
 */
public class TmplateParam {



    public static  Map<String, String> tmpParam(){
        Map<String, String> parm=Maps.newHashMap();
        parm.put(InPutFieldCodeEnum.USERNAME.name(),get("user_name"));
        parm.put(InPutFieldCodeEnum.PASSWORD.name(),get("user_password"));
        parm.put(InPutFieldCodeEnum.ANSWER.name(),get("user_answer"));
        parm.put(InPutFieldCodeEnum.EMAIL.name(),get("user_email"));
        parm.put(InPutFieldCodeEnum.PHONE.name(),get("user_phone"));
        parm.put(InPutFieldCodeEnum.QUESTION.name(),get("user_question"));
        parm.put(InPutFieldCodeEnum.ROLE.name(),get("user_role"));
        return parm;

      }






      //从文件里读取参数
      public static String getValue(String key){

        String path=Const.BASE_PATH+"/src/main/json/gateway_param.json";
        JSONObject jsonObject=JsonReadUtils.readJsonFile(path);
        JSONObject inFields=jsonObject.getJSONObject("inFields");
        return inFields.getString(key);
      }


    /**
     * 从配置文件读取参数
     * @param key
     * @return
     */
    public static String get(String key){
        ResourceBundle bundle=ResourceBundle.getBundle("params",Locale.CHINA);

        return bundle.getString(key);
      }

}


