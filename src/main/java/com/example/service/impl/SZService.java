package com.example.service.impl;

import org.json.JSONObject;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @author yicg
 * @createTime 2020年01月15日 16:54:00
 * @Description
 */

@Service
public class SZService {

     public JSONObject searchreportService(Object object){

         Map<String,Object> map=new HashMap<>();
         map.put("statusCode",1);
         map.put("statusMsg","查询成功,查得结果");
         map.put("quotaID","RZ018");

         JSONObject jsonObject=new JSONObject();
         return null;
     }



}
