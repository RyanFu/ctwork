package com.example.common.auto;



public enum InPutFieldCodeEnum {

    //auto_test_case表中参数映射
    USERNAME,
    PASSWORD
    ;


    /**
     * 判断参数合法性
     */
    public static boolean isValidName(String name) {
        for (InPutFieldCodeEnum userStatusEnum : InPutFieldCodeEnum.values()) {
            if (userStatusEnum.name().equals(name)) {
                return true;
            }
        }
        return false;
    }
}
