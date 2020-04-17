package com.shuanger.springbootexample.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 权益信息表
 * </p>
 *
 * @author zhaixiaoshuang
 * @since 2020-04-16
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class ChannelInterestInfo implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 主键id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 自定义ID
     */
    private String channelInterestId;

    /**
     * 关联权益ID
     */
    private String interestId;

    /**
     * 名称
     */
    private String interestName;

    /**
     * 上架量
     */
    private Long onlineCount;

    /**
     * 当前总量
     */
    private Long currentTotalCount;

    /**
     * 0-未删除, 1-删除
     */
    private Boolean deleted;

    /**
     * 创建时间
     */
    private LocalDateTime createdTime;

    /**
     * 修改时间
     */
    private LocalDateTime modifiedTime;


}
