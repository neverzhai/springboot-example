CREATE TABLE `sys_privilege`(
                                `id` INT NOT NULL AUTO_INCREMENT COMMENT '权限id',
                                `privilege_name` VARCHAR(50) NOT NULL COMMENT '权限名称',
                                `privilege_url`  VARCHAR(255) COMMENT '权限URL',
                                `deleted` BIT(1) COMMENT '0-未删除, 1-删除',
                                `created_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                                `modified_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
                                PRIMARY KEY (`id`)
) ENGINE = INNODB AUTO_INCREMENT = 1 DEFAULT CHARSET = utf8 COLLATE = utf8_bin COMMENT = '权限表';