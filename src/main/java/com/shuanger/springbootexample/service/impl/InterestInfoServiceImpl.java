package com.shuanger.springbootexample.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.shuanger.springbootexample.InterestInfoBo;
import com.shuanger.springbootexample.domain.InterestInfo;
import com.shuanger.springbootexample.mapper.InterestInfoMapper;
import com.shuanger.springbootexample.service.InterestInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import javax.management.Query;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 权益信息表 服务实现类
 * </p>
 *
 * @author zhaixiaoshuang
 * @since 2020-04-16
 */
@Service
public class InterestInfoServiceImpl extends ServiceImpl<InterestInfoMapper, InterestInfo> implements InterestInfoService {

    @Override
    public List<InterestInfoBo> queryEnoughInterest(String interestId, Long count) {
        LambdaQueryWrapper<InterestInfo> queryWrapper = new QueryWrapper<InterestInfo>().lambda()
                .eq(InterestInfo::getInterestId, interestId);

        List<InterestInfo> interestInfos = list(queryWrapper);
        ArrayList<InterestInfoBo> updatedInfos = new ArrayList<>();

        int index = 0;
        while (count > 0) {
            Assert.isTrue(index < interestInfos.size() , "不足");
            InterestInfo interestInfo = interestInfos.get(index);
            InterestInfoBo infoBo = new InterestInfoBo();
            infoBo.setBatchId(interestInfo.getBatchId());
            infoBo.setInterestName(interestInfo.getInterestName());

            if(interestInfo.getOfflineCount() > count) {
                infoBo.setReduceCount(count);
                count = 0L;

            } else {
                count = count - interestInfo.getOfflineCount();
                infoBo.setReduceCount(interestInfo.getOfflineCount());
            }

            updatedInfos.add(infoBo);
        }
        return updatedInfos;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void batchUpdate(List<InterestInfoBo> interestInfoBos) {
        this.baseMapper.batchUpdate(interestInfoBos);
    }
}
