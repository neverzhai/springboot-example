package com.shuanger.springbootexample.service;

import com.shuanger.springbootexample.InterestInfoBo;
import com.shuanger.springbootexample.domain.InterestInfo;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 权益信息表 服务类
 * </p>
 *
 * @author zhaixiaoshuang
 * @since 2020-04-16
 */
public interface InterestInfoService extends IService<InterestInfo> {

    List<InterestInfoBo> queryEnoughInterest(String interestId, Long count);

    void batchUpdate(List<InterestInfoBo> interestInfoBos);
}
