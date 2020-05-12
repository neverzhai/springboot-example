package com.shuanger.springbootexample.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.shuanger.springbootexample.domain.TransactionalTest;

/**
 * @author: zhaixiaoshuang
 * @date: 2020-04-27 22:13
 * @description: 事务测试接口</>
 */
public interface TransactionalTestService extends IService<TransactionalTest> {
    void createOne();
}
