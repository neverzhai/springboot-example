package com.shuanger.springbootexample.PO;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class SystemUserPO {
    Integer id;
    String username;
    String userEmail;
    String userPassword;
    String userInfo;
    String headImg;
    Timestamp createDate;
    Timestamp modifiedDate;
}
