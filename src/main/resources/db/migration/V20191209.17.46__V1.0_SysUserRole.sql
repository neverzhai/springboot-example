CREATE TABLE `sys_user_role`(
                                `user_id` INT COMMENT '用户id',
                                `role_id` INT COMMENT '角色id',
                                `created_date` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                                `modified_date` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间'
) ENGINE = INNODB CHARSET = utf8 COLLATE = utf8_bin COMMENT = '用户角色关系表';