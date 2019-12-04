package com.shuanger.springbootexample.params;

import lombok.Data;

@Data
public class CreateUserParam {

    String username;
    String userEmail;
    String userPassword;
    String userInfo;
    String headImg;
}
