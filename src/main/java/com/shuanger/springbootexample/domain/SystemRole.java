package com.shuanger.springbootexample.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import com.sun.org.apache.xpath.internal.operations.Bool;
import lombok.Data;

/**
 * @author: zhaixiaoshuang
 * @date: 2020-04-01 22:58
 * @description: 角色domain
 */
@Data
@TableName("sys_role")
public class SystemRole extends BaseEntity {

    private Long id;

    private String roleName;

    private Boolean enabled;

    private Long createBy;

}