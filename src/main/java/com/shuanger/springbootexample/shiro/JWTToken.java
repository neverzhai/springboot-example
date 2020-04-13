package com.shuanger.springbootexample.shiro;

import org.apache.shiro.authc.AuthenticationToken;

/**
 * @author: zhaixiaoshuang
 * @date: 2020-04-08 23:10
 * @description: 重写authorization token
 */
public class JWTToken implements AuthenticationToken {

    private String token;

    public JWTToken(String token) {
        this.token = token;
    }

    // principal he  credential 分别代表啥意思
    @Override
    public Object getPrincipal() {
        return token;
    }

    @Override
    public Object getCredentials() {
        return token;
    }
}