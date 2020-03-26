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

    public ResponseResult(Integer status, T data) {
        this.status = status;
        this.data = data;
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
     * 返回成功code
     * @param <T>
     * @return
     */
    public static<T> ResponseResult createBySuccess() {

        return new ResponseResult(ResponseStatusEnum.SUCCESS.getCode());
    }

    /**
     * 返回成功code和message
     * @param <T>
     * @return
     */
    public static<T> ResponseResult createBySuccessMessage() {

        return new ResponseResult(ResponseStatusEnum.SUCCESS.getCode(),ResponseStatusEnum.SUCCESS.getMsg());
    }

    /**
     * 返回成功code,data
     * @param data
     * @param <T>
     * @return
     */
    public static<T> ResponseResult createBySuccess(T data) {

        return new ResponseResult(ResponseStatusEnum.SUCCESS.getCode(),data);
    }

    /**
     * 返回成功code,message,data
     * @param data
     * @param <T>
     * @return
     */
    public static<T> ResponseResult createBySuccessMessage(T data) {

        return new ResponseResult(ResponseStatusEnum.SUCCESS.getCode(),ResponseStatusEnum.SUCCESS.getMsg(),data);
    }




    /**
     * 返回失败
     * @param <T>
     * @return
     */
    public static<T> ResponseResult createByError(String message) {

        return new ResponseResult(ResponseStatusEnum.FAIL.getCode(),message);
    }



    public static<T> ResponseResult createByErrorCodeMessage(int status,String message) {

        return new ResponseResult(status,message);
    }
}
