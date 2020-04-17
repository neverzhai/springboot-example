CREATE TABLE `sys_user`(
                           `id` BIGINT(20) UNSIGNED  NOT NULL AUTO_INCREMENT COMMENT '用户id',
                           `username` VARCHAR(50) NOT NULL COMMENT '用户名',
                           `user_email` VARCHAR(50)  NOT NULL COMMENT '用户邮箱',
                           `password` VARCHAR(255)  NOT NULL COMMENT '用户密码',
                           `user_info` VARCHAR(255) COMMENT '用户简介',
                           `head_img` BLOB COMMENT '用户头像',
                           `deleted` BIT(1) COMMENT '0-未删除, 1-删除',
                           `created_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                           `modified_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
                           PRIMARY KEY (`id`)
) ENGINE = INNODB AUTO_INCREMENT = 1 DEFAULT CHARSET = utf8 COLLATE = utf8_bin COMMENT = '用户信息表';