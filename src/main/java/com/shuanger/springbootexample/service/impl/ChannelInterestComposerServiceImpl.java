package com.shuanger.springbootexample.service.impl;

import cn.hutool.core.util.IdUtil;
import com.shuanger.springbootexample.InterestInfoBo;
import com.shuanger.springbootexample.domain.ChannelInterestInfo;
import com.shuanger.springbootexample.params.CreateChannelInterestParam;
import com.shuanger.springbootexample.service.ChannelInterestComposerService;
import com.shuanger.springbootexample.service.ChannelInterestInfoService;
import com.shuanger.springbootexample.service.InterestInfoService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: zhaixiaoshuang
 * @date: 2020-04-17 00:03
 * @description:
 */
@Service
public class ChannelInterestComposerServiceImpl implements ChannelInterestComposerService {

    @Resource
    private ChannelInterestInfoService channelInterestInfoService;

    @Resource
    private InterestInfoService interestInfoService;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void createChannelInterest(CreateChannelInterestParam param) {

        List<InterestInfoBo> interestInfoBos = interestInfoService.queryEnoughInterest(param.getInterestId(), param.getCount());
        ArrayList<ChannelInterestInfo> newChannelInterests = new ArrayList<>();

        interestInfoBos.forEach(info -> {
            ChannelInterestInfo interestInfo = new ChannelInterestInfo();
            interestInfo.setChannelInterestId(IdUtil.simpleUUID().substring(0, 10));
            interestInfo.setInterestId(param.getInterestId());
            interestInfo.setInterestName(info.getInterestName());

            interestInfo.setOnlineCount(info.getReduceCount());
            interestInfo.setCurrentTotalCount(info.getReduceCount());
            newChannelInterests.add(interestInfo);
        });

        boolean saveBatch = channelInterestInfoService.saveBatch(newChannelInterests);
        interestInfoService.batchUpdate(interestInfoBos);
    }
}