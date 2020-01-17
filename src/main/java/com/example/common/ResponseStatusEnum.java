package com.example.common;

import lombok.Getter;

/**
 * @author yicg
 * @createTime 2020年01月17日 12:02:00
 * @Description
 */
@Getter
public enum  ResponseStatusEnum {
    SUCCESS(0,"成功"),
    FAIL(1,"失败")
    ;
    private int code;

    private String msg;


    ResponseStatusEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
