package com.example.common;

import com.example.enums.InPutFieldCode;

import java.util.HashMap;

/**
 * @author yicg
 * @createTime 2020年03月20日 10:06:00
 * @Description
 */
public class FeatureComponent {


    public static HashMap<String, String> parameterMaps = new HashMap<String, String>();

    static {
        if (parameterMaps.size() == 0) {
            parameterMaps.put("input.user.idNumber", InPutFieldCode.IDCARD.name());
            parameterMaps.put("input.user.mobileNumber", InPutFieldCode.PHONENUM.name());
            parameterMaps.put("input.user.name", InPutFieldCode.NAME.name());
            parameterMaps.put("input.user.idType", InPutFieldCode.IDTYPE.name());
            parameterMaps.put("input.order.paymentBankCardNo", InPutFieldCode.BANKCARDNUM.name());
            parameterMaps.put("input.order.bankCardNumber", InPutFieldCode.BANKCARDNUM.name());
            parameterMaps.put("input.cycle", "CYCLE");
            parameterMaps.put("input.type", "TYPE");
            parameterMaps.put("input.startTime", "STARTTIME");
            parameterMaps.put("input.endTime", "ENDTIME");
            parameterMaps.put("input.ip", InPutFieldCode.IP.name());
            parameterMaps.put("input.trafficIdentifier", InPutFieldCode.TRAFFIC.name());
            parameterMaps.put("input.productIdentifier", InPutFieldCode.PRODUCT.name());
            parameterMaps.put("input.userId", InPutFieldCode.UID.name());
            parameterMaps.put("input.user.externalUserId", InPutFieldCode.UID.name());
            parameterMaps.put("input.order.externalOrderId", InPutFieldCode.ORDERID.name());
            parameterMaps.put("input.user.contactPhoneNumber", InPutFieldCode.CONTACTPHONENUM.name());
            parameterMaps.put("input.contactUser.mobileNumber", InPutFieldCode.CONTACTPHONENUMS.name());
            parameterMaps.put("input.contactUser.name", InPutFieldCode.CONTACNAME.name());
            parameterMaps.put("input.loanType", InPutFieldCode.LOANTYPE.name());
            parameterMaps.put("input.tid", InPutFieldCode.TID.name());
            parameterMaps.put("input.user.productCd", InPutFieldCode.PRODUCT.name());
            parameterMaps.put("input.user.trafficUserId", InPutFieldCode.TRAFFIC_USERID.name());
            parameterMaps.put("input.user.trafficCode", InPutFieldCode.TRAFFIC_CODE.name());
            parameterMaps.put("input.user.gid", InPutFieldCode.GID.name());
            parameterMaps.put("input.pid", InPutFieldCode.PID.name());
            parameterMaps.put("latitude", "latitude");
            parameterMaps.put("longitude", "longitude");
            parameterMaps.put("input.engineId", InPutFieldCode.engineId.name());
            parameterMaps.put("input.card.phone.no", InPutFieldCode.CARDPHONENO.name());
            parameterMaps.put("input.user.seller.no", InPutFieldCode.USER_SELLER_NO.name());
            parameterMaps.put("input.user.seller.type", InPutFieldCode.USER_SELLER_TYPE.name());
            parameterMaps.put("input.order.amount", InPutFieldCode.ORDER_AMT.name());


        }

    }
}
