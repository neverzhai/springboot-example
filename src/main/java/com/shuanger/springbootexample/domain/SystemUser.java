package com.shuanger.springbootexample.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("sys_bk_user")
public class SystemUser extends BaseEntity{

    private Long id;

    private String username;

    private String password;

    private String salt;

    private Long creator;
    //Domain 中有操作domain的方法

}
