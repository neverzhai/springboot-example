CREATE TABLE `sys_user`(
 `id` INT NOT NULL PRIMARY KEY AUTO_INCREMENT COMMENT '用户id',
 `user_name` VARCHAR(50) NOT NULL COMMENT '用户名',
 `user_email` VARCHAR(50)  NOT NULL COMMENT '用户邮箱',
 `user_password` VARCHAR(255)  NOT NULL COMMENT '用户密码',
 `user_info` VARCHAR(255) COMMENT '用户简介',
 `head_img` BLOB COMMENT '用户头像',
 `created_date` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
 `modified_date` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间'
);
INSERT INTO sys_user ( user_name, user_email, user_password, user_info)
VALUES('shuanger', 'zhaixiaoshuang@jd.com', '123456','a programmer');


