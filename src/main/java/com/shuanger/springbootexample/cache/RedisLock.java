package com.shuanger.springbootexample.cache;


import java.lang.annotation.*;


@Inherited
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface RedisLock {

    String prefix() default Constants.REDIS_LOCK_PREFIX;

    /**
     * redis锁默认释放时间
     * 设置值时需要保证在该时间内任务一定会执行完。
     * 如果未执行完，超时释放锁，下一次任务进入可能会导致任务并行执行。
     * @return
     */
    int releaseAfter() default Constants.ONE_MINUTE * 10;
}
