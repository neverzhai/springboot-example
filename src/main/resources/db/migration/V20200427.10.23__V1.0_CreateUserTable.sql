CREATE TABLE `transactional_test`(
                           `id` BIGINT(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键id',
                           `name` VARCHAR(32)  NOT NULL COMMENT '名称',
                           `deleted` BIT(1) NOT NULL DEFAULT b'0' COMMENT '0-未删除, 1-删除',
                           `created_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                           `modified_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
                           PRIMARY KEY (`id`)
) ENGINE = INNODB AUTO_INCREMENT = 1 DEFAULT CHARSET = utf8 COLLATE = utf8_bin COMMENT = '事务测试表';