package com.example.vo;

import com.example.common.ResponseStatusEnum;
import lombok.Data;

import java.io.Serializable;

@Data
public class ResponseResult<T> implements Serializable {
    private Integer status;
    private String message;
    private T data;


    public ResponseResult(Integer status) {
        this.status = status;
    }


    public ResponseResult(Integer status, String message, T data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

    public ResponseResult(Integer status, String message) {
        this.status = status;
        this.message = message;
    }

    /**
     * 返回正确结果
     * @param data
     * @param <T>
     * @return
     */
    public static<T> ResponseResult successResponse(T data) {

        return new ResponseResult(ResponseStatusEnum.SUCCESS.getCode(),ResponseStatusEnum.SUCCESS.getMsg(),data);
    }

    /**
     * 返回失败
     * @param data
     * @param <T>
     * @return
     */
    public static<T> ResponseResult failResponse(T data) {

        return new ResponseResult(ResponseStatusEnum.FAIL.getCode(),ResponseStatusEnum.FAIL.getMsg(),data);
    }

}
