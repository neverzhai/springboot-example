//package com.shuanger.springbootexample.controller;
//
//import com.shuanger.springbootexample.DTO.SystemUserDTO;
//import com.shuanger.springbootexample.domain.SystemUser;
//import com.shuanger.springbootexample.params.CreateUserParam;
//import com.shuanger.springbootexample.params.QueryUserParam;
//import com.shuanger.springbootexample.service.SystemUserService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//@RequestMapping("/user")
//public class SystemUserController {
//
//    @Autowired
//    SystemUserService systemUserService;
//
//    @RequestMapping("/query")
//    public SystemUserDTO queryUserByUsername(@RequestBody QueryUserParam queryUserParam) {
//        SystemUser systemUser = systemUserService.queryByUsername(queryUserParam.getUsername());
//
//        SystemUserDTO systemUserDTO = new SystemUserDTO();
//        systemUserDTO.setUsername(systemUser.getUsername());
////        systemUserDTO.setUserEmail(systemUser.getUserEmail());
////        systemUserDTO.setUserInfo(systemUser.getUserInfo());
//        return systemUserDTO;
//    }
//
//    @RequestMapping("/create")
//    public Integer insert(@RequestBody CreateUserParam createUserParam) {
//       return systemUserService.insert(createUserParam);
//    }
//}
