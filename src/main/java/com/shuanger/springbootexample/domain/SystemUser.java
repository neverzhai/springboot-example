package com.shuanger.springbootexample.domain;

import lombok.Data;

@Data
public class SystemUser {
    String username;
    String userEmail;
    String userPassword;
    String userInfo;
    String headImg;
}
