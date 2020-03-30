package com.example.common.auto;



public enum InPutFieldCode {

    //auto_test_case表中参数映射
    USERNAME,
    PASSWORD
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
