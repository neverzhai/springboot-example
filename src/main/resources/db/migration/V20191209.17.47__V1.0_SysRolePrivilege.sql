CREATE TABLE `sys_role_privilege`(
                                     `role_id` INT COMMENT '角色id',
                                     `privilege_id` INT COMMENT '权限id',
                                     `deleted` BIT(1) COMMENT '0-未删除, 1-删除',
                                     `created_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                                     `modified_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间'
) ENGINE = INNODB CHARSET = utf8 COLLATE = utf8_bin COMMENT = '角色权限关系表';