package com.example.common.auto;


/**
 *  auto_test_case表中参数映射
 */
public enum InPutFieldCodeEnum {
    /**
     * 用户名
     */
    USERNAME,
    /**
     * 密码
     */
    PASSWORD,
    /**
     * 注册问题
     */
    ANSWER,
    /**
     * 注册答案
     */
    QUESTION,

    /**
     * 注册邮箱
     */
    EMAIL,

    /**
     * 注册手机号
     */
    PHONE,
    /**
     * 用户角色
     */
    ROLE
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
