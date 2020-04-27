package com.shuanger.springbootexample.controller;

import com.shuanger.springbootexample.common.response.RespCode;
import com.shuanger.springbootexample.common.response.RespEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: zhaixiaoshuang
 * @date: 2020-04-26 22:54
 * @description: 事务机制实验
 */
@RestController
@RequestMapping("/transactional")
public class TransactionalController {

    @RequestMapping("/test")
    public RespEntity test1() {


        return RespEntity.create(RespCode.SUCCESS);
    }
}