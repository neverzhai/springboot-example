package com.shuanger.springbootexample.cache;



import java.lang.annotation.*;


@Inherited
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface RedisCache {
    String prefix() default Constants.PREFIX;

    String key() default "";

    int expire() default Constants.DEFAULT_CACHE_SECONDS;
}
