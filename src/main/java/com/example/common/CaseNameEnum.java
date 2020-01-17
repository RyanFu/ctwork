package com.example.common;

import lombok.Getter;

@Getter
public enum CaseNameEnum {

    LOGIN("用户登录"),
    GET_USER_INFO("获取用户登录信息")


    ;
    private String message;

    CaseNameEnum(String message) {
        this.message = message;
    }
}
