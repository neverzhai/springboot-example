package com.shuanger.springbootexample.idGenerator.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.shuanger.springbootexample.idGenerator.domain.IdGeneratorEntity;

/**
 * @author: zhaixiaoshuang
 * @date: 2020-06-17 18:23
 * @description:
 */
public interface IdGeneratorService extends IService<IdGeneratorEntity> {
    String generateProviderId();
}
