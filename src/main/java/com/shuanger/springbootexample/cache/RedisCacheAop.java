package com.shuanger.springbootexample.cache;

import cn.hutool.core.lang.TypeReference;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.lang.reflect.Type;


@Aspect
@Slf4j
@Component
public class RedisCacheAop {

    @Autowired
    private CacheService cacheService;

    @Around("@annotation(annotation)&&@annotation(com.shuanger.springbootexample.cache.RedisCache)")
    public Object doAroundCache(ProceedingJoinPoint pjp, RedisCache annotation) throws Throwable {

        MethodSignature signature = (MethodSignature) pjp.getSignature();
        Method method = signature.getMethod();
        Object[] args = pjp.getArgs();
        Type genericReturnType = method.getGenericReturnType();

        String parsedKey = KeyParser.parseExpressionKey(annotation.key(), args);
        log.info("SPEL 解析 key ：{}", parsedKey);
        String redisKey = String.format("%s_%s_%s_%s", annotation.prefix(), pjp.getTarget().getClass().getSimpleName(),
                method.getName(), parsedKey);

        Object result = null;

        result = cacheService.get(redisKey, new TypeReference<Object>() {
            @Override
            public Type getType() {
                return genericReturnType;
            }
        });

        if (null != result) {
            log.info("AOP缓存命中 key ：{}", redisKey);
            return result;
        }
        result = pjp.proceed();
        if (null != result) {
            cacheService.set(redisKey, result, (long) annotation.expire());
        }
        return result;
    }


}
