package com.shuanger.springbootexample.domain;

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
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        //  授权，基于用户角色和权限来决定用户可以进行什么操作
        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        // 认证， 用户是否存在于DB中

        String username = (String) authenticationToken.getPrincipal();
        if (!"javaboy".equals(username)) {
            throw new UnknownAccountException("账户不存在!");
        }
        return new SimpleAuthenticationInfo(username, "123", getName());

    }
}
