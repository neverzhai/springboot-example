package com.shuanger.springbootexample.mapper;


import com.shuanger.springbootexample.PO.SystemUserPO;
import org.apache.ibatis.annotations.Param;

public interface SystemUserMapper {
    SystemUserPO queryByUsername(@Param("username") String username);
}
