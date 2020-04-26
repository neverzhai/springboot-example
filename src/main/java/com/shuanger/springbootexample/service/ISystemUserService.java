package com.shuanger.springbootexample.service;

import com.baomidou.mybatisplus.core.toolkit.support.SFunction;
import com.baomidou.mybatisplus.extension.service.IService;
import com.shuanger.springbootexample.domain.SystemUser;

/**
 * @author: zhaixiaoshuang
 * @date: 2020-04-02 11:14
 * @description: 系统用户服务类
 */
public interface ISystemUserService extends IService<SystemUser> {

    SystemUser queryBy(SFunction<SystemUser, Object> conditional, String value);

    Integer insert(SystemUser systemUser);
}
