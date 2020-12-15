CREATE DATABASE `mybatis-plus-learn`;

USE `mybatis-plus-learn`;

CREATE TABLE `mybatis_tenant_user`
(
    `id`       INT(11) AUTO_INCREMENT PRIMARY KEY NOT NULL,
    `username` VARCHAR(255) COMMENT '用户名',
    `tenantId` INT(11)                            NOT NULL
) ENGINE = 'InnoDB' ,
  CHAR SET = 'UTF8MB4'
    COMMENT ='用户表';