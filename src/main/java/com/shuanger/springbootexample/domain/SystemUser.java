package com.shuanger.springbootexample.domain;

import lombok.Data;

@Data
public class SystemUser {
    String username;
    String userEmail;
    String userPassword;
    String userInfo;
    String headImg;


    //Domain 中有操作domain的方法

}
