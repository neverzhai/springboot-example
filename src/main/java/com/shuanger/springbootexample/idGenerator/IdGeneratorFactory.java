package com.shuanger.springbootexample.idGenerator;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


@Service
public class IdGeneratorFactory {

    @Autowired(required = false)
    private Map<String, IdGenerator> factoryMapper = new ConcurrentHashMap<>();

    public static final String ORDER = "ORDER";
    public static final String EXCHANGE = "EXCHANGE";

    public IdGenerator get(String key) {
        Assert.isTrue(this.checkKeyExists(key), "key不存在");
        return factoryMapper.get(key);
    }

    public boolean checkKeyExists(String key) {
        if (StringUtils.isBlank(key)) {
            return false;
        }
        return factoryMapper.containsKey(key);
    }

}
