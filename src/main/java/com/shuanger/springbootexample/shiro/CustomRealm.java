package com.shuanger.springbootexample.shiro;

import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

/**
 * @author: shuanger
 * @date: 2019-12-23
 * @description : 自定义的shiro relam
 */
public class CustomRealm extends AuthorizingRealm {

    // 调用权限相关时才会调用
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        //  授权，基于用户角色和权限来决定用户可以进行什么操作
        // 从数据库中读出用户的角色和权限信息， 此处要用到redis 缓存
        return null;
    }

    //在JWT filter 中调用 login 时调用这个方法， 判断用户是否存在
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String  token = (String) authenticationToken.getPrincipal();
        return new SimpleAuthenticationInfo(token, token, getName());

    }
}
