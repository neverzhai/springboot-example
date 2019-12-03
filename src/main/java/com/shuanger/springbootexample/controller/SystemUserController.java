package com.shuanger.springbootexample.controller;

import com.shuanger.springbootexample.VO.SystemUserVO;
import com.shuanger.springbootexample.domain.SystemUser;
import com.shuanger.springbootexample.params.QueryUserParam;
import com.shuanger.springbootexample.service.SystemUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class SystemUserController {

    @Autowired
    SystemUserService systemUserService;

    @RequestMapping()
    public SystemUserVO queryUserByUsername(@RequestBody QueryUserParam queryUserParam) {
        SystemUser systemUser = systemUserService.queryByUsername(queryUserParam.getUsername());

        SystemUserVO systemUserVO = new SystemUserVO();
        systemUserVO.setUsername(systemUser.getUsername());
        systemUserVO.setUserEmail(systemUser.getUserEmail());
        systemUserVO.setUserInfo(systemUser.getUserInfo());
        return systemUserVO;
    }
}
