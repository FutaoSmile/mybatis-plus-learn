CREATE TABLE `mybatis_tenant_article`
(
    `id`       INT(11) AUTO_INCREMENT PRIMARY KEY NOT NULL,
    `tenantId` INT(11)                            NOT NULL,


    `title`    VARCHAR(255) COMMENT '标题',
    `content`  VARCHAR(255) COMMENT '内容'


) ENGINE = 'InnoDB' ,
  CHAR SET = 'UTF8MB4'
    COMMENT ='文章表';