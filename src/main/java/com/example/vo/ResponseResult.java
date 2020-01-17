package com.example.vo;

import lombok.Data;

@Data
public class ResponseResult<T> {
    private Integer status;
    private String message;
    private T data;


    public ResponseResult(Integer status, String message, T data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

    public ResponseResult(Integer status, String message) {
        this.status = status;
        this.message = message;
    }

}
