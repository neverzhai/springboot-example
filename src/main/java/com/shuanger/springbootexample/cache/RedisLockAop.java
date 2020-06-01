package com.shuanger.springbootexample.cache;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;


@Aspect
@Slf4j
@Component
public class RedisLockAop {

    @Autowired
    private CacheService cacheService;

    @Around("@annotation(annotation)&&@annotation(com.shuanger.springbootexample.cache.RedisLock)")
    public void doAroundCache(ProceedingJoinPoint pjp, RedisLock annotation) throws Throwable {
        MethodSignature signature = (MethodSignature) pjp.getSignature();
        Method method = signature.getMethod();
        String redisKey = String.format("%s_%s_%s", annotation.prefix(), pjp.getTarget().getClass().getSimpleName(),
                method.getName());
        log.info("redis lock key ：{}", redisKey);

        boolean acquireLock = cacheService.setNX(redisKey, Constants.CACHED, (long) annotation.releaseAfter());

        if (!acquireLock) {
            log.info("未获取到锁，类:{} 方法:{} 不执行。", pjp.getTarget().getClass().getSimpleName(), method.getName());
            return;
        }
        log.info("获取到锁： key:{} 超时释放时间：{} 秒", redisKey, annotation.releaseAfter());
        try {
            pjp.proceed();
        } finally {
            cacheService.del(redisKey);
            log.info("释放锁 key:{}", redisKey);
        }
    }


}
