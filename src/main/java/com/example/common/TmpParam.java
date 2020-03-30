package com.example.common;

import com.alibaba.fastjson.JSONObject;
import com.example.enums.InPutFieldCode;
import com.example.util.JsonReadUtils;
import com.google.common.collect.Maps;

import java.util.Map;
import java.util.UUID;

/**
 * @author yicg
 * @createTime 2020年03月20日 10:43:00
 * @Description   gateway模版参数
 */
public class TmpParam {



    public static  Map<String, String> tmpParam(){
        Map<String, String> parm=Maps.newHashMap();
        parm.put(InPutFieldCode.IDCARD.name(),getValue("IDCARD"));
        parm.put(InPutFieldCode.PHONENUM.name(),getValue("PHONENUM"));
        parm.put(InPutFieldCode.NAME.name(),getValue("NAME"));
        parm.put(InPutFieldCode.IDTYPE.name(),getValue("IDTYPE"));
        parm.put(InPutFieldCode.BANKCARDNUM.name(),getValue("BANKCARDNUM"));
        parm.put("CYCLE","CYCLE");
        parm.put("TYPE","TYPE");
        parm.put("STARTTIME","STARTTIME");
        parm.put("ENDTIME","ENDTIME");
        parm.put("IP",getValue("IP"));
        parm.put(InPutFieldCode.TRAFFIC.name(),getValue("TRAFFIC"));
        parm.put(InPutFieldCode.PRODUCT.name(),getValue("PRODUCT"));
        parm.put(InPutFieldCode.UID.name(),getValue("UID"));
        parm.put(InPutFieldCode.ORDERID.name(),getValue("ORDERID"));
        parm.put(InPutFieldCode.CONTACTPHONENUM.name(),getValue("CONTACTPHONENUM"));
        parm.put(InPutFieldCode.CONTACTPHONENUMS.name(),getValue("CONTACTPHONENUMS"));
        parm.put(InPutFieldCode.CONTACNAME.name(),getValue("CONTACNAME"));
        parm.put(InPutFieldCode.LOANTYPE.name(),getValue("LOANTYPE"));
        parm.put(InPutFieldCode.TID.name(),getValue("TID"));
        parm.put(InPutFieldCode.TRAFFIC_USERID.name(),getValue("TRAFFIC_USERID"));
        parm.put(InPutFieldCode.TRAFFIC_CODE.name(),getValue("TRAFFIC_CODE"));
        parm.put(InPutFieldCode.GID.name(),UUID.randomUUID().toString());
        parm.put(InPutFieldCode.PID.name(),UUID.randomUUID().toString());
        parm.put("latitude","latitude");
        parm.put("longitude","longitude");
        parm.put(InPutFieldCode.engineId.name(),getValue("engineId"));
        parm.put(InPutFieldCode.CARDPHONENO.name(),getValue("PHONENUM"));
        parm.put(InPutFieldCode.USER_SELLER_NO.name(),getValue("USER_SELLER_NO"));
        parm.put(InPutFieldCode.USER_SELLER_TYPE.name(),getValue("USER_SELLER_TYPE"));
        parm.put(InPutFieldCode.ORDER_AMT.name(),getValue("ORDER_AMT"));





        return parm;

      }



      public static String getValue(String key){

        String path=Const.BASE_PATH+"/src/main/json/gateway_param.json";
        JSONObject jsonObject=JsonReadUtils.readJsonFile(path);
        JSONObject inFields=jsonObject.getJSONObject("inFields");
        return inFields.getString(key);
      }

}
