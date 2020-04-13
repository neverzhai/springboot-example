package com.shuanger.springbootexample.params;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @author: zhaixiaoshuang
 * @date: 2020-04-08 23:28
 * @description: 用户登陆参数
 */
@Data
public class LoginParam {

    @NotBlank(message = "username不能为空")
    private String username;

    @NotBlank(message = "password不能为空")
    private String password;
}