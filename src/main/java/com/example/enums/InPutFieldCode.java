package com.example.enums;



public enum InPutFieldCode {
    PID,
    NAME,
    PHONENUM,
    CONTACTPHONENUM,
    CONTACTPHONENUMS,
    CONTACNAME,
    UID,
    BANKCARDNUM,
    BANKCARDPHONE,
    BANKCARDNAME,
    BANKCARDIDCARD,
    IDTYPE,
    ORDERID,
    TRAFFIC,
    PRODUCT,
    IP,
    LOANTYPE,
    TID,
    TRAFFIC_CODE,
    TRAFFIC_USERID,
    IDCARD,
    USER_RFE1_PHONE_NUMBER,
    USER_RFE2_PHONE_NUMBER,
    GID,
    // 奢了吗特殊字段
    PHONENO,
    USERNAME,
    USERIDNUMBER,
    CARDNUMBER,
    engineId,
    ORDER_AMT,

    CARDPHONENO,
    USER_SELLER_NO,
    USER_SELLER_TYPE

    ;
    /**
     * 判断参数合法性
     */
    public static boolean isValidName(String name) {
        for (InPutFieldCode userStatusEnum : InPutFieldCode.values()) {
            if (userStatusEnum.name().equals(name)) {
                return true;
            }
        }
        return false;
    }
}
