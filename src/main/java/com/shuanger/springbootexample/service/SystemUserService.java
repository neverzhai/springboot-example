package com.shuanger.springbootexample.service;

import com.shuanger.springbootexample.PO.SystemUserPO;
import com.shuanger.springbootexample.domain.SystemUser;
import com.shuanger.springbootexample.mapper.SystemUserMapper;
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
}
