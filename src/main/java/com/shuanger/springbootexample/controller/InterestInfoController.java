package com.shuanger.springbootexample.controller;


import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.IdUtil;
import com.shuanger.springbootexample.common.response.RespCode;
import com.shuanger.springbootexample.common.response.RespEntity;
import com.shuanger.springbootexample.domain.InterestInfo;
import com.shuanger.springbootexample.params.CreateInterestParam;
import com.shuanger.springbootexample.params.LoginParam;
import com.shuanger.springbootexample.service.InterestInfoService;
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
@RequestMapping("/springbootexample/interestInfo")
public class InterestInfoController {

    @Resource
    private InterestInfoService interestInfoService;

    @RequestMapping("/add")
    public boolean createInterestInfo(@RequestBody @Validated CreateInterestParam param) {

        InterestInfo interestInfo = new InterestInfo();
        BeanUtil.copyProperties(param, interestInfo);
        interestInfo.setInterestId(IdUtil.simpleUUID().substring(0, 10));
        interestInfo.setOfflineCount(param.getTotalCount());

        boolean success = interestInfoService.save(interestInfo);

        return success;

//        return RespEntity.create(RespCode.SUCCESS, success);

    }
}

