package com.shuanger.springbootexample.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

/**
 * @author: zhaixiaoshuang
 * @date: 2020-04-27 22:14
 * @description: 事务测试实体
 */
@Data
public class TransactionalTest extends BaseEntity {

    @TableId(type = IdType.AUTO)
    private Long id;

    private String name;
}