CREATE TABLE `sys_role`(
                           `id` INT NOT NULL AUTO_INCREMENT COMMENT '角色id',
                           `role_name` VARCHAR(50) NOT NULL COMMENT '角色名',
                           `enabled` INT COMMENT '有效标志',
                           `create_by` BIGINT COMMENT '创建人',
                           `created_date` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                           `modified_date` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
                           PRIMARY KEY (`id`)
) ENGINE = INNODB AUTO_INCREMENT = 1 DEFAULT CHARSET = utf8 COLLATE = utf8_bin COMMENT = '角色表';