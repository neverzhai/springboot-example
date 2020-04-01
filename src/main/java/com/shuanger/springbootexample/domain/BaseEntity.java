package com.shuanger.springbootexample.domain;

import lombok.Data;

import java.util.Date;

/**
 * @author: zhaixiaoshuang
 * @date: 2020-04-01 22:53
 * @description: domain共享的成员变量
 */
@Data
public class BaseEntity {

    private Boolean deleted;

    private Date createdTime;

    private Date modifiedTime;
}