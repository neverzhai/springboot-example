package com.shuanger.springbootexample.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.shuanger.springbootexample.domain.TransactionalTest;
import com.shuanger.springbootexample.mapper.TransactionalTestMapper;
import com.shuanger.springbootexample.service.TransactionalTestService;
import com.shuanger.springbootexample.service.TransactionalTestService2;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @author: zhaixiaoshuang
 * @date: 2020-04-27 22:17
 * @description:
 */
@Service
@Slf4j
public class TransactionalTestServiceImpl extends ServiceImpl<TransactionalTestMapper, TransactionalTest> implements TransactionalTestService {

    @Resource
    private TransactionalTestService2 transactionalTestService2;

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void createOne() {

        TransactionalTest test1 = new TransactionalTest();
        test1.setName("testName1");
        boolean save = save(test1);

        transactionalTestService2.createOne();

        throw new RuntimeException();

    }
}