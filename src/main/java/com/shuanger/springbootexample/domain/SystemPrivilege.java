package com.shuanger.springbootexample.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author: zhaixiaoshuang
 * @date: 2020-04-01 23:01
 * @description: 系统权限定义
 */
@Data
@TableName("sys_privilege")
public class SystemPrivilege extends BaseEntity {

    private Long id;

    private String privilegeName;

    private String privilegeUrl;

}