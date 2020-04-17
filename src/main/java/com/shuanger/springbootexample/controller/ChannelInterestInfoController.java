package com.shuanger.springbootexample.controller;


import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.IdUtil;
import com.shuanger.springbootexample.common.response.RespCode;
import com.shuanger.springbootexample.common.response.RespEntity;
import com.shuanger.springbootexample.common.util.JWTUtil;
import com.shuanger.springbootexample.domain.InterestInfo;
import com.shuanger.springbootexample.domain.SystemUser;
import com.shuanger.springbootexample.params.CreateChannelInterestParam;
import com.shuanger.springbootexample.params.CreateInterestParam;
import com.shuanger.springbootexample.params.LoginParam;
import com.shuanger.springbootexample.service.ChannelInterestComposerService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * <p>
 * 权益信息表 前端控制器
 * </p>
 *
 * @author zhaixiaoshuang
 * @since 2020-04-16
 */
@RestController
@RequestMapping("/springbootexample/channelInterestInfo")
public class ChannelInterestInfoController {

    @Resource
    private ChannelInterestComposerService composerService;

    @RequestMapping("/add")
    public boolean createInterestInfo(@RequestBody @Validated CreateChannelInterestParam param) {

        composerService.createChannelInterest(param);

        return true;

    }
}

