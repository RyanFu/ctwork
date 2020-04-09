package com.example.enums;

import lombok.Getter;

/**
 * 案例执行结果
 */
@Getter
public enum CaseEnum {

    SUCCESS(1,"执行成功"),
    FAIL(0,"执行失败"),
    UNKNOW(3,"未执行"),


    KEY_VALUE(100,"key-value"),
    APPLICATION_JSON(101,"application/json")
    ;

    private int code;
    private String message;

    CaseEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }
}
