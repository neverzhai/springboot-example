package com.shuanger.springbootexample.mapper;


import com.shuanger.springbootexample.PO.SystemUserPO;
import com.shuanger.springbootexample.domain.SystemUser;
import org.apache.ibatis.annotations.Param;

public interface SystemUserMapper {
    SystemUserPO queryByUsername(@Param("username") String username);

    int insert(SystemUser systemUser);
}
