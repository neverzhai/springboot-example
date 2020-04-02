package com.shuanger.springbootexample.common.response;

/**
 * @author: zhaixiaoshuang
 * @date: 2020-04-02 11:28
 * @description: 返回结果类型
 */
public class RespEntity<T> {

    private String code;

    private String message;

    private T data;


    protected RespEntity() {}

    protected RespEntity(String code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public static <T> RespEntity<T> create(RespCode respCode, T data) {
        return new RespEntity<>(respCode.getCode(), respCode.getMessage(), data);
    }


    public static <T> RespEntity<T> create(RespCode respCode) {
       return new RespEntity<>(respCode.getCode(), respCode.getMessage(), null);
    }



}
