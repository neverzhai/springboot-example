CREATE TABLE `interest_info`(
                           `id` BIGINT(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键id',
                           `interest_id` VARCHAR(16) NOT NULL COMMENT '自定义ID',
                           `interest_name` VARCHAR(32)  NOT NULL COMMENT '名称',
                           `total_count` BIGINT(20) UNSIGNED NOT NULL DEFAULT 0 COMMENT '总量',
                           `online_count` BIGINT(20) UNSIGNED NOT NULL DEFAULT 0 COMMENT '上架总量',
                           `offline_count` BIGINT(20) UNSIGNED NOT NULL DEFAULT 0 COMMENT '未上架总量',
                           `deleted` BIT(1) NOT NULL DEFAULT b'0' COMMENT '0-未删除, 1-删除',
                           `created_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                           `modified_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
                           PRIMARY KEY (`id`)
) ENGINE = INNODB AUTO_INCREMENT = 1 DEFAULT CHARSET = utf8 COLLATE = utf8_bin COMMENT = '权益信息表';