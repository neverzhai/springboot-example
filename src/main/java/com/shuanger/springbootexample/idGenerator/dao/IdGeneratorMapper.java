package com.shuanger.springbootexample.idGenerator.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.shuanger.springbootexample.idGenerator.domain.IdGeneratorEntity;

/**
 * @author: zhaixiaoshuang
 * @date: 2020-06-17 18:15
 * @description:
 */
public interface IdGeneratorMapper extends BaseMapper<IdGeneratorEntity> {

    void generateId(IdGeneratorEntity entity);
}
