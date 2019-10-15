package com.example.enums;

import lombok.Getter;

/**
 * 案例执行结果
 */
@Getter
public enum CaseEnum {

    SUCCESS(1,"执行成功"),
    FAIL(0,"执行失败"),
    UNKNOW(3,"未执行")
    ;

    private int code;
    private String message;

    CaseEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }
}
