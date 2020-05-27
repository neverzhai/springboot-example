package com.shuanger.springbootexample.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.shuanger.springbootexample.domain.TransactionalTest;

/**
 * @author: zhaixiaoshuang
 * @date: 2020-04-29 10:44
 * @description: 第二个服务接口
 */
public interface TransactionalTestService2 extends IService<TransactionalTest> {
    void createOne();
}
