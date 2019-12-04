package com.shuanger.springbootexample.service;

import com.shuanger.springbootexample.PO.SystemUserPO;
import com.shuanger.springbootexample.domain.SystemUser;
import com.shuanger.springbootexample.mapper.SystemUserMapper;
import com.shuanger.springbootexample.params.CreateUserParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SystemUserService {

    @Autowired
    SystemUserMapper systemUserMapper;

    public SystemUser queryByUsername(String username) {
        SystemUserPO systemUserPO = systemUserMapper.queryByUsername(username);

        SystemUser systemUser = new SystemUser();
        systemUser.setUsername(systemUserPO.getUsername());
        systemUser.setUserEmail(systemUserPO.getUserEmail());
        systemUser.setUserInfo(systemUserPO.getUserInfo());
        systemUser.setHeadImg(systemUserPO.getHeadImg());
        systemUser.setUserPassword(systemUserPO.getUserPassword());
        return systemUser;
    }

    public int insert(CreateUserParam createUserParam) {
        SystemUser systemUser = new SystemUser();
        systemUser.setUsername(createUserParam.getUsername());
        systemUser.setUserPassword(createUserParam.getUserPassword());
        systemUser.setUserEmail(createUserParam.getUserEmail());
        systemUser.setUserInfo(createUserParam.getUserInfo());
        systemUser.setHeadImg(createUserParam.getHeadImg());

       return systemUserMapper.insert(systemUser);
    }
}
