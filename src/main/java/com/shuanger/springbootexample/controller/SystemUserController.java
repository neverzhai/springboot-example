package com.shuanger.springbootexample.controller;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.IdUtil;
import com.shuanger.springbootexample.DTO.SystemUserDTO;
import com.shuanger.springbootexample.common.response.RespCode;
import com.shuanger.springbootexample.common.response.RespEntity;
import com.shuanger.springbootexample.common.util.JWTUtil;
import com.shuanger.springbootexample.domain.SystemUser;
import com.shuanger.springbootexample.params.CreateUserParam;
import com.shuanger.springbootexample.params.LoginParam;
import com.shuanger.springbootexample.params.QueryUserParam;
import com.shuanger.springbootexample.service.ISystemUserService;
import com.shuanger.springbootexample.service.impl.SystemUserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class SystemUserController {

    @Autowired
    ISystemUserService systemUserService;

    @RequestMapping("/login")
    public RespEntity login(@RequestBody LoginParam loginParam) {

        SystemUser systemUser = systemUserService.queryBy(SystemUser::getUsername, loginParam.getUsername());
        String token = JWTUtil.sign(systemUser);

        return RespEntity.create(RespCode.SUCCESS, token);

    }

    @RequestMapping("/query")
    public RespEntity queryUserByUsername(@RequestBody QueryUserParam queryUserParam) {
        SystemUser systemUser = systemUserService.queryBy(SystemUser::getUsername, queryUserParam.getUsername());

        SystemUserDTO userDTO = systemUser.toDTO();

        return RespEntity.create(RespCode.SUCCESS, userDTO);

    }

    @RequestMapping("/create")
    public RespEntity insert(@RequestBody CreateUserParam createUserParam) {

        Integer count = createSystemUser(createUserParam);

        return RespEntity.create(RespCode.SUCCESS, count);
    }

    @Transactional(rollbackFor = Exception.class)
    private Integer createSystemUser(CreateUserParam createUserParam) {

        SystemUser user = new SystemUser();
        BeanUtil.copyProperties(createUserParam, user);
        user.setSalt(IdUtil.simpleUUID());

        Integer count = systemUserService.insert(user);

        return count;

    }
}
