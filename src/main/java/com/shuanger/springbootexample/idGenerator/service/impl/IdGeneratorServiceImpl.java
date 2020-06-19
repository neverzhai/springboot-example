package com.shuanger.springbootexample.idGenerator.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.shuanger.springbootexample.idGenerator.dao.IdGeneratorMapper;
import com.shuanger.springbootexample.idGenerator.domain.IdGeneratorEntity;
import com.shuanger.springbootexample.idGenerator.service.IdGeneratorService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author: zhaixiaoshuang
 * @date: 2020-06-17 18:28
 * @description:
 */
@Slf4j
@Service
public class IdGeneratorServiceImpl extends ServiceImpl<IdGeneratorMapper, IdGeneratorEntity> implements IdGeneratorService {

    @Override
    public String generateProviderId() {
        return generateIdWithPrefix("PO");
    }


    private  String generateIdWithPrefix(String prefix) {
        IdGeneratorEntity entity = new IdGeneratorEntity();
        entity.setPrefix(prefix);
        try {
            this.baseMapper.generateId(entity);
        } catch (Exception e) {
            log.error("数据库创建id出错", e.getMessage());
        }

        long id = entity.getId();

        return String.format("%s%06d", prefix,id);
    }
}
