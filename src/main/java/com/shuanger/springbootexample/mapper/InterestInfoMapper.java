package com.shuanger.springbootexample.mapper;

import com.shuanger.springbootexample.InterestInfoBo;
import com.shuanger.springbootexample.domain.InterestInfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 * 权益信息表 Mapper 接口
 * </p>
 *
 * @author zhaixiaoshuang
 * @since 2020-04-16
 */
public interface InterestInfoMapper extends BaseMapper<InterestInfo> {

    Long batchUpdate(List<InterestInfoBo> interestInfoBos);
}
