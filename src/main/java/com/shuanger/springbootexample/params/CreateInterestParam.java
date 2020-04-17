package com.shuanger.springbootexample.params;

import lombok.Data;

/**
 * @author: zhaixiaoshuang
 * @date: 2020-04-16 23:54
 * @description:
 */
@Data
public class CreateInterestParam {

    /**
     * 名称
     */
    private String interestName;

    /**
     * 总量
     */
    private Long totalCount;
}