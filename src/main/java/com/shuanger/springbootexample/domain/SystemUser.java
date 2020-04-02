package com.shuanger.springbootexample.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("sys_user")
public class SystemUser extends BaseEntity{

    private Long id;

    private String username;

    private String userEmail;

    private String password;

    private String userInfo;

    private String headImg;

//    private String salt;

    //Domain 中有操作domain的方法

}
