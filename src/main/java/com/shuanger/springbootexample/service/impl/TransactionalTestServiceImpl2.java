package com.shuanger.springbootexample.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.shuanger.springbootexample.domain.TransactionalTest;
import com.shuanger.springbootexample.mapper.TransactionalTestMapper;
import com.shuanger.springbootexample.service.TransactionalTestService2;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author: zhaixiaoshuang
 * @date: 2020-04-29 10:53
 * @description: 第二个事务服务实现类
 */
@Service
public class TransactionalTestServiceImpl2 extends ServiceImpl<TransactionalTestMapper, TransactionalTest> implements TransactionalTestService2 {

    @Override
    @Transactional(propagation = Propagation.NESTED)
    public void createOne() {

        TransactionalTest test2 = new TransactionalTest();
        test2.setName("testName2");
        save(test2);
    }
}