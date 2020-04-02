package com.shuanger.springbootexample.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import com.shuanger.springbootexample.DTO.SystemUserDTO;
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

    private String salt;

    public SystemUserDTO toDTO() {
        SystemUserDTO userDTO = new SystemUserDTO();
        userDTO.setUsername(username);
        userDTO.setUserEmail(userEmail);
        userDTO.setUserInfo(userInfo);
        return userDTO;
    }

    //Domain 中有操作domain的方法

}
