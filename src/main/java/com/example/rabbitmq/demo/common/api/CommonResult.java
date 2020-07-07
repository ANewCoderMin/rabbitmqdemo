package com.example.rabbitmq.demo.common.api;

public class CommonResult<T> {

    private long code;
    private String status;
    private T data;
    public static <T> CommonResult<T> success(String status){

        return new CommonResult<>(200L,status);
    }

    public CommonResult(long code, String status) {
        this.code = code;
        this.status = status;
    }
}
