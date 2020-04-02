package com.shuanger.springbootexample.common.response;

/**
 * @author: zhaixiaoshuang
 * @date: 2020-04-02 11:34
 * @description: 返回结果状态码
 */
public enum RespCode {
    SUCCESS("000000", "操作成功"),
    ;

    private String code;

    private String message;


    RespCode(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }}
