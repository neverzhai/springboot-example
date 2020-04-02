package com.shuanger.springbootexample.controller;

import com.shuanger.springbootexample.DTO.SystemUserDTO;
import com.shuanger.springbootexample.common.response.RespCode;
import com.shuanger.springbootexample.common.response.RespEntity;
import com.shuanger.springbootexample.domain.SystemUser;
import com.shuanger.springbootexample.params.QueryUserParam;
import com.shuanger.springbootexample.service.impl.SystemUserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class SystemUserController {

    @Autowired
    SystemUserServiceImpl systemUserService;

    @RequestMapping("/query")
    public RespEntity queryUserByUsername(@RequestBody QueryUserParam queryUserParam) {
        SystemUser systemUser = systemUserService.queryBy(SystemUser::getUsername, queryUserParam.getUsername());

        SystemUserDTO userDTO = systemUser.toDTO();

        return RespEntity.create(RespCode.SUCCESS, userDTO);

    }

//    @RequestMapping("/create")
//    public Integer insert(@RequestBody CreateUserParam createUserParam) {
//       return systemUserService.insert(createUserParam);
//    }
}
