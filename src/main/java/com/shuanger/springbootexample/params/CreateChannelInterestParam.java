package com.shuanger.springbootexample.params;

import lombok.Data;

/**
 * @author: zhaixiaoshuang
 * @date: 2020-04-16 23:59
 * @description:
 */
@Data
public class CreateChannelInterestParam {

    /**
     * 关联权益ID
     */
    private String interestId;

    /**
     * 上架量
     */
    private Long count;

}