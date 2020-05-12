package com.shuanger.springbootexample.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.support.SFunction;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.shuanger.springbootexample.domain.SystemUser;
import com.shuanger.springbootexample.mapper.SystemUserMapper;
import com.shuanger.springbootexample.params.CreateUserParam;
import com.shuanger.springbootexample.service.ISystemUserService;
import org.springframework.stereotype.Service;

@Service
public class SystemUserServiceImpl extends ServiceImpl<SystemUserMapper, SystemUser> implements ISystemUserService {

    @Override
    public SystemUser queryBy(SFunction<SystemUser, Object> conditional, String value) {
        LambdaQueryWrapper<SystemUser> queryWrapper = new QueryWrapper<SystemUser>().lambda()
                .eq(conditional, value)
                .eq(SystemUser::getDeleted, false);

        SystemUser systemUser = getOne(queryWrapper);

        return systemUser;
    }

    @Override
    public Integer insert(CreateUserParam createUserParam) {
        return null;
    }

}
