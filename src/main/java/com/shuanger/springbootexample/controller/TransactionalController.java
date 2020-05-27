package com.shuanger.springbootexample.controller;

import com.shuanger.springbootexample.service.TransactionalTestService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author: zhaixiaoshuang
 * @date: 2020-04-26 22:54
 * @description: 事务机制实验
 */
@RestController
@RequestMapping("/transactional")
public class TransactionalController {

    @Resource
    private TransactionalTestService transactionalTestService;

    @RequestMapping("/test")
    public void test1() {
       transactionalTestService.createOne();
        return;
    }
}